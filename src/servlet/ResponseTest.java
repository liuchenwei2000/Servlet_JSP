/**
 * 
 */
package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应（response）详解
 * <p>
 * 大多数情况下，使用响应只是为了向客户发回数据，会对响应调用两个方法： 
 * setContentType() 和  getWriter()/getOutputStream。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class ResponseTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应GET请求
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 服务器必须要告诉浏览器发回了些什么，这样浏览器才能正确的展现响应，可能启动一个辅助应用，
		 * 如PDF阅读器或视频播放器，也可能向用户呈现HTML，或者把响应的字节保存为一个下载文件等。
		 * 
		 * 内容类型 ContentType 指的就是MIME类型，它是HTTP响应中必须有的一个信息。
		 * 
		 * 常用MIME类型有：text/html、application/pdf、video/quicktime、image/jpeg、application/jar。
		 */
		resp.setContentType("image/png");

		// "/" 表示Web应用的根
		InputStream is = getServletContext().getResourceAsStream("/images/cross.png");

		int len = 0;
		byte[] buffer = new byte[1024 * 4];

		/*
		 * ServletResponse 接口只提供了两个流可供选择： 
		 * PrintWriter：字符流，使用它的 println() 方法写数据。
		 * ServletOutputStream：字节流，使用它的 write() 方法写数据。
		 */
		ServletOutputStream outputStream = resp.getOutputStream();
		while ((len = is.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}

		outputStream.flush();
		outputStream.close();
	}
	
	/**
	 * 响应POST请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// forward 是请求转发，是服务器端跳转
		RequestDispatcher dispatcher = req.getRequestDispatcher("country.jsp");
		dispatcher.forward(req, resp);
		
		// sendRedirect 是响应重定向，是客户端跳转
		// 可以使用相对 URL 作为参数，有两种类型：前面没有斜线和有斜线（"/"）
		// 没有斜线的 URL ，容器会相对于原先的请求 URL 建立完整的 URL ，如
		// 原本请求地址是 http://localhost/app1/foo.do，下面的调用会重定向到 http://localhost/app1/test/bar.do
		resp.sendRedirect("test/bar.do");
		
		// 有斜线的URL，这个斜线意味着“Web容器的根”，容器会相对于 Web 应用本身建立完整的URL，而不是相对于请求原来的URL，如
		// 原本请求地址是 http://localhost/app1/foo.do，下面的调用会重定向到 http://localhost/test/bar.do
		// test 是另一个有别于 app1 的应用
		resp.sendRedirect("/test/bar.do");
	}
}
