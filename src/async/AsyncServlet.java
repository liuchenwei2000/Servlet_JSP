/**
 * 
 */
package async;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异步处理 servlet示例
 * <p>
 * 异步处理通过AsyncContext类来处理。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
// 对希望启用异步调用的Servlet而言，需要显式指定开启异步调用，或使用@WebServlet的asyncSupported属性或者在web.xml中进行配置。
@WebServlet(name="async", urlPatterns={"/async"}, asyncSupported=true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		
		PrintWriter out = response.getWriter();
		out.println("<title>异步调用示例</title>");
		out.println("进入servlet的时间 ：" + new Date() + "</br>");
		out.flush();
		
		// 创建AsyncContext，开始异步调用
		AsyncContext async = request.startAsync();
		// 为异步调用注册监听器
		async.addListener(new MyAsyncListener());
		// 设置异步调用的超时时长
		async.setTimeout(30 * 1000);
		// 启动异步调用的线程
		async.start(new LongTask(async));
		
		out.println("结束servlet的时间 ：" + new Date() + "</br>");
		out.flush();
	}
}
