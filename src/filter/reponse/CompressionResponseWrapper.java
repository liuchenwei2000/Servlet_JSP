/**
 * 
 */
package filter.reponse;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 自定义的 HttpServletResponse 实现
 * <p>
 * 如果想创建定制请求或响应对象，只需要继承某个请求或响应包装类即可。（装饰模式的体现）
 * 包装类包装了实际的请求或响应对象，而且把调用委托给实际的对象，还允许对定制请求或响应做所需的额外处理。
 * <p>
 * 4个常用包装类：
 * ServletRequestWrapper、HttpServletRequestWrapper、ServletResponseWrapper、HttpServletResponseWrapper。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年7月10日
 */
public class CompressionResponseWrapper extends HttpServletResponseWrapper {

	private GZIPServletOutputStream gzipOS;// servlet 响应的压缩输出流

	private PrintWriter pw;// 压缩输出流的 PrintWriter 对象

	/**
	 * @param response
	 *            实际的 响应对象
	 */
	public CompressionResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	/** 
	 * 向调用者返回一个有压缩功能的 ServletOutputStream
	 * 
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.gzipOS == null) {
			// 用压缩输出流包装原来的响应输出流
			this.gzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
		}
		return this.gzipOS;
	}

	/** 
	 * 向调用者返回一个有压缩功能的 PrintWriter
	 * 
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		if (this.pw == null) {
			this.pw = new PrintWriter(new OutputStreamWriter(getOutputStream(), getResponse().getCharacterEncoding()));
		}
		return this.pw;
	}

	@Override
	public void setContentLength(int len) {
		// 忽略此方法实现，因为输出会被压缩
	}

	public GZIPOutputStream getGZIPOutputStream() {
		return gzipOS.realOutputStream;
	}

	/**
	 * 压缩输出流包装器（装饰模式）
	 */
	class GZIPServletOutputStream extends ServletOutputStream {

		private GZIPOutputStream realOutputStream;// 真正的压缩输出流

		public GZIPServletOutputStream(ServletOutputStream os) throws IOException {
			this.realOutputStream = new GZIPOutputStream(os);
		}

		@Override
		public void write(int b) throws IOException {
			// 这个方法把 write() 调用委托给 GZIP 压缩流，从而实现压缩装饰。
			realOutputStream.write(b);
		}
	}
}
