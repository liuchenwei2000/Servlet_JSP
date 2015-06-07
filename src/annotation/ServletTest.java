/**
 * 
 */
package annotation;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��Annotation����Servletʾ��
 * <p>
 * @WebServlet ���ڲ���Servlet�࣬��Ҫ�������£�
 * <p>
 * name��ָ����Servlet������
 * value��urlPatterns��ָ����Servlet�����URL
 * initParams��Ϊ��Servlet���ò���
 * loadOnStartup������Servlet���ó�load-on-startup
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
@WebServlet(name = "servlettest", urlPatterns = { "/st.do" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "user", value = "tom"),
		@WebInitParam(name = "password", value = "111") })
public class ServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ����ͨ��ServletConfig��ȡ���õĲ���
		ServletConfig servletConfig = getServletConfig();
		String id = servletConfig.getInitParameter("user");
		String password = servletConfig.getInitParameter("password");
		System.out.println("id=" + id);
		System.out.println("password=" + password);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
}
