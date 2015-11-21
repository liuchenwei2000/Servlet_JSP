/**
 * 
 */
package servlet.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MVC之Controller
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class CountryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取客户端提交的参数
		String country = req.getParameter("country");
		// 调用 Model，执行业务逻辑操作
		CountryHelper helper = new CountryHelper();
		String area = helper.getArea(country);

		// 使用request对象保存属性/值，用于向View传递信息
		req.setAttribute("area", area);
		req.setAttribute("country", country);
		
		// 服务器端请求转发，转发给View（具体可以是JSP、Servlet或HTML）
		RequestDispatcher dispatcher = req.getRequestDispatcher("country.jsp");
		dispatcher.forward(req, resp);
	}
}
