/**
 * 
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 会话（HttpSession）详解
 * <p>
 * HttpSession 对象可以保存跨同一个客户多个请求的会话状态，也就是说，与一个特定客户的整个会话期间，HttpSession 会持久存储。
 * 对于会话期间客户做的所有请求，从中得到的所有信息都可以用 HttpSession 对象保存。
 * <p>
 * HTTP 协议使用的是无状态连接，对容器而言，每个请求都来自于一个新的客户。
 * 客户需要一个唯一的会话ID，对客户的第一个请求，容器会生成一个唯一的会话ID，并通过响应把它返回给客户。
 * 客户再在以后的每一个请求中发回这个会话ID。容器看到ID后，就会找到匹配的 HttpSession 对象，并把这个对象与请求关联。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class HttpSessionTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 容器必须以某种方式把会话ID作为响应的一部分交给客户，而客户必须把会话ID作为请求的一部分发回。
	 * 最简单而且最常用的方式是通过 Cookie 交换这个会话ID信息。比如 HTTP 响应的首部会有如 
	 * Set-Cookie:JSESSIONID=0ADCD1245E 这样的信息，而客户请求的首部也会有如 Cookie:JSESSIONID=0ADCD1245E 这样的信息。
	 * 
	 * 实际上，容器几乎会做 cookie 的所有工作。你确实必须告诉容器想创建或使用一个会话（通过调用 request.getSession() 方法），
	 * 除此之外，生成会话ID、创建新的cookie对象、把会话ID放到cookie中、把cookie设置为响应的一部分等工作都将由容器负责。
	 * 对于后续的请求，容器会从请求中的cookie得到会话ID，将这个会话ID与一个现有的会话匹配，并把会话与当前请求关联。
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		
		PrintWriter writer = resp.getWriter();
		if(session.isNew()) {// 判断 session 是否是新建的
			writer.println("session is new.");
		} else {
			writer.println("session is not new.");
		}
		
		// 返回第一次创建会话的时间。
		session.getCreationTime();
		// 返回容器最后一次得到包含这个会话ID的请求后过去了多长时间（毫秒）。
		session.getLastAccessedTime();
		// 会话有三种死法：超时、在会话对象上调用 invalidate()、应用结束。
		// 指定对于这个会话，客户请求的最大时间间隔（秒），即超时时限。
		session.setMaxInactiveInterval(20 * 60);
		session.getMaxInactiveInterval();
		// 结束会话，当前存储在会话中的所有会话属性也会解除绑定。
		session.invalidate();
		
		writer.flush();
		writer.close();
	}

	/**
	 * 如果客户禁用cookie，那浏览器就会忽略"Set-Cookie"响应首部，这就只能采用URL重写了。
	 * URL重写能取得置于cookie中的会话ID，并把会话ID附加到访问应用的各个URL的最后。
	 * 比如 HTTP 响应发回的 HTML 变成了如 <a href="http://localhost/myapp/login.do;JSESSIONID=0ADCD1245E">click</a>；
	 * 而客户端请求将变成 GET /myapp/login.do;JSESSIONID=0ADCD1245E 其中分号分隔符不是统一的，不同的开发商有不同的分隔符。
	 * 
	 * 容器并不知道 cookie 是否工作，所以向客户返回第一个响应时，它会同时尝试 cookie 和 URL 重写两种做法。
	 * URL 重写只对动态生成的页面（比如JSP）有效，对静态的HTML页面是无效的。
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		req.getSession();

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		// 如果客户不接受 cookie，URL 重写会自动发生，但必须显式的对所有 URL 编码
		// 向 URL 增加额外的会话ID信息
		writer.println(" <a href=\"" + resp.encodeURL("/sdemo.do") + "\">click</a>");
		writer.println("</body></html>");
		writer.flush();
		
		// 如果想把请求重定向到另外一个URL但还想使用同一个会话，主要使用如下方式：
//		resp.encodeRedirectURL("/sdemo.do");
	}
}
