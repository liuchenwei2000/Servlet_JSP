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
 * 使用Annotation配置Servlet示例
 * <p>
 * @WebServlet 用于部署Servlet类，主要属性如下：
 * <p>
 * name：指定该Servlet的名称
 * value或urlPatterns：指定该Servlet处理的URL
 * initParams：为该Servlet配置参数
 * loadOnStartup：将该Servlet配置成load-on-startup
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
@WebServlet(name = "servlettest", urlPatterns = { "/st.do" }, loadOnStartup = 1, initParams = {
		@WebInitParam(name = "user", value = "tom"),
		@WebInitParam(name = "password", value = "111") })
public class ServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 可以通过ServletConfig获取配置的参数
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
