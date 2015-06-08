/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet示例
 * <p>
 * Servlet通常被称为服务器端小程序，是运行在服务器端的程序，用于处理及相应客户端的请求。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class ServletTest extends HttpServlet {// 必须继承HttpServlet

	private static final long serialVersionUID = 1L;

	/**
	 * 通常无需重写下面这两个方法，除非需要初始化Servlet时，完成某些资源初始化的方法，才考虑重写init方法。
	 * 如果需要在销毁Servlet之前，先完成某些资源的回收，比如关闭数据库连接，才需要重写destroy方法。
	 */
	
	/**
	 * 初始化动作放在init方法中而不是构造方法中
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);// 需要首先调用父类init方法
		System.out.println("init complete");
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	/**
	 * 以下是响应客户端请求的方法
	 */
	
	/**
	 * 响应GET请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 可以通过ServletConfig获取配置的参数
		ServletConfig servletConfig = getServletConfig();
		String id = servletConfig.getInitParameter("id");
		String password = servletConfig.getInitParameter("password");
		System.out.println("id=" + id);
		System.out.println("password=" + password);

		// 下面的方式可以获取当前应用在服务器上的绝对路径
		String realPath = getServletContext().getRealPath("");
		System.out.println("servlet real path=" + realPath);
	}

	/**
	 * 响应POST请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	/**
	 * 响应DELETE请求
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	/**
	 * 响应PUT请求
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
}
