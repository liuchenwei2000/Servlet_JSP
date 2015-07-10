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
 * ��ȷ�ĵ�ѹ����Ӧ Filter ʾ��
 * <p>
 * ͨ�������Զ���� HttpServletResponse ʵ�֣�������ͨ�� chain.doFilter(req, resp) ���ݸ� servlet��
 * �����Ϳ����� servlet д���֮������������ظ��ͻ�֮ǰ���ɹ������ػ���������
 *  
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class CorrectCompressionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	/**
	 * ������Ӧ��ѹ������
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String validEncoding = request.getHeader("Accept-Encoding");
		if (validEncoding.contains("gzip")) {// �жϿͻ����Ƿ���� GZIP ѹ��
			CompressionResponseWrapper responseWrapper = new CompressionResponseWrapper(response);
			// ֪ͨ���������ʾ����֮ǰ�ȶ����ѹ��
			responseWrapper.setHeader("Content-Encoding", "gzip");
			// �����Զ���� HttpServletResponse �� servlet
			chain.doFilter(req, responseWrapper);
			// ��Ӧ���ؿͻ�֮ǰ�ػ������
			GZIPOutputStream gzipOutputStream = responseWrapper.getGZIPOutputStream();
			gzipOutputStream.finish();// ����ѹ���������������ݷ��͵�ԭ������Ӧ��
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
	}
}
