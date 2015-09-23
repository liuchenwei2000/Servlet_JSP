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
 * �Զ���� HttpServletResponse ʵ��
 * <p>
 * ����봴�������������Ӧ����ֻ��Ҫ�̳�ĳ���������Ӧ��װ�༴�ɡ���װ��ģʽ�����֣�
 * ��װ���װ��ʵ�ʵ��������Ӧ���󣬶��Ұѵ���ί�и�ʵ�ʵĶ��󣬻�����Զ����������Ӧ������Ķ��⴦��
 * <p>
 * 4�����ð�װ�ࣺ
 * ServletRequestWrapper��HttpServletRequestWrapper��ServletResponseWrapper��HttpServletResponseWrapper��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��7��10��
 */
public class CompressionResponseWrapper extends HttpServletResponseWrapper {

	private GZIPServletOutputStream gzipOS;// servlet ��Ӧ��ѹ�������

	private PrintWriter pw;// ѹ��������� PrintWriter ����

	/**
	 * @param response
	 *            ʵ�ʵ� ��Ӧ����
	 */
	public CompressionResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	/** 
	 * ������߷���һ����ѹ�����ܵ� ServletOutputStream
	 * 
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.gzipOS == null) {
			// ��ѹ���������װԭ������Ӧ�����
			this.gzipOS = new GZIPServletOutputStream(getResponse().getOutputStream());
		}
		return this.gzipOS;
	}

	/** 
	 * ������߷���һ����ѹ�����ܵ� PrintWriter
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
		// ���Դ˷���ʵ�֣���Ϊ����ᱻѹ��
	}

	public GZIPOutputStream getGZIPOutputStream() {
		return gzipOS.realOutputStream;
	}

	/**
	 * ѹ���������װ����װ��ģʽ��
	 */
	class GZIPServletOutputStream extends ServletOutputStream {

		private GZIPOutputStream realOutputStream;// ������ѹ�������

		public GZIPServletOutputStream(ServletOutputStream os) throws IOException {
			this.realOutputStream = new GZIPOutputStream(os);
		}

		@Override
		public void write(int b) throws IOException {
			// ��������� write() ����ί�и� GZIP ѹ�������Ӷ�ʵ��ѹ��װ�Ρ�
			realOutputStream.write(b);
		}
	}
}
