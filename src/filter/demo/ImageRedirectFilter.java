/**
 * 
 */
package filter.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * ͼƬ������������
 * <p>
 * Ϊ�˷�ֹ��վ�ڵ���Դ��������վ����������ʹ�ù�������ɷ������Ĺ��ܡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��6��8��
 */
public class ImageRedirectFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ��ȡ�����Ǵ��ĸ�ҳ�����ӹ����ģ����������Ի�ô���Ϣ���к�������
		String referer = ((HttpServletRequest) request).getHeader("Referer");
		String serverName = request.getServerName();
		
		System.out.println("��referer��" + referer + " ��servername��" + serverName);
		
		if (referer == null || !referer.contains(serverName)) {
			// ������ӵ�ַ����������վ���򷵻ش���ͼƬ
			request.getRequestDispatcher("/images/error.png").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
