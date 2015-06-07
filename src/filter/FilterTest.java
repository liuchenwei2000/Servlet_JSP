/**
 * 
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Filterʾ��
 * <p>
 * ����һ��Filterֻ���������裺
 * 1������Filterʵ���ࡣ
 * 2������Filter����web.xml�����ã���
 * <p>
 * Filter������֤�û��Ƿ��ѵ�¼�����û�е�¼��ֱ����ת����¼ҳ�档
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class FilterTest implements Filter {// ����ʵ��Filter
	
	private FilterConfig config;

	/**
	 * �������Filter�ĳ�ʼ��
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}
	
	/**
	 * ����Filter����ǰ�����ĳЩ��Դ�Ļ��ա�
	 */
	@Override
	public void destroy() {
		this.config = null;
	}

	/**
	 * ���ķ�����ʵ�����ع��˹��ܣ��÷������Ƕ�ÿ��������Ӧ���ӵĶ��⴦��
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String loginPage = config.getInitParameter("loginPage");
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		String servletPath = ((HttpServletRequest)request).getServletPath();
		
		// �������һ��user��Ϣ����װ�Ѿ���¼
		session.setAttribute("user", "admin");
		// session ��û��user��Ϣ����Ϊ��δ��¼
		if (session.getAttribute("user") == null && !servletPath.endsWith(loginPage)) {
			request.setAttribute("��ʾ", "����û�е�¼��");
			// ת����¼����
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			// Filterֻ����ʽ����������Ȼ�����е�Ŀ�ĵ�ַ��
			chain.doFilter(request, response);
		}
	}
}
