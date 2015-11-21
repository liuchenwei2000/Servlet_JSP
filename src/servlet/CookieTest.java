/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 详解
 * <p>
 * 可以使用 cookie 在服务器和客户之间交换名/值对（string），cookie 实际上就是在客户和服务器之间交换的一小段数据。
 * 服务器先把 cookie 发送给客户，客户做出下一个请求时再把 cookie 返回给服务器。
 * cookie 的一大妙处是，用户不必介入，cookie交换是自动完成的（前提是客户端支持cookie）。
 * 默认地，cookie与会话的寿命一样长，一旦客户离开浏览器，cookie就会消失。
 * 但是可以让cookie活的更长一些，甚至在浏览器已经关闭后仍存活。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class CookieTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应GET请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 从客户请求得到 cookie（或多个 cookie）
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {// 只能通过遍历的方式查找想要的那个 cookie
			if ("username".equalsIgnoreCase(cookie.getName())) {
				String userName = cookie.getValue();
				System.out.println("Hello " + userName);
				break;
			}
		}

		// 创建一个新 Cookie，名值对
		Cookie cookie = new Cookie("email", "aaa@gmail.com");
		// 设置 cookie 在客户端上的存活时间，单位是秒
		cookie.setMaxAge(30 * 60);
		// 把 cookie 发送给客户，可以发送多个 cookie
		resp.addCookie(cookie);
	}
}
