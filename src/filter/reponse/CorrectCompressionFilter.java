/**
 * 
 */
package filter.reponse;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 正确的的压缩响应 Filter 示例
 * <p>
 * 通过建立自定义的 HttpServletResponse 实现，并把它通过 chain.doFilter(req, resp) 传递给 servlet，
 * 这样就可以在 servlet 写输出之后并且在输出返回给客户之前，由过滤器截获这个输出。
 *  
 * @author 刘晨伟
 *
 * 创建日期：2015年6月1日
 */
public class CorrectCompressionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * 进行响应的压缩操作
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String validEncoding = request.getHeader("Accept-Encoding");
		if (validEncoding.contains("gzip")) {// 判断客户端是否接受 GZIP 压缩
			CompressionResponseWrapper responseWrapper = new CompressionResponseWrapper(response);
			// 通知浏览器在显示数据之前先对其解压缩
			responseWrapper.setHeader("Content-Encoding", "gzip");
			// 传递自定义的 HttpServletResponse 给 servlet
			chain.doFilter(req, responseWrapper);
			// 响应返回客户之前截获输出流
			GZIPOutputStream gzipOutputStream = responseWrapper.getGZIPOutputStream();
			gzipOutputStream.finish();// 结束压缩流，将所有数据发送到原来的响应流
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
	}
}
