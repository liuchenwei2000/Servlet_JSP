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
 * �첽���� servletʾ��
 * <p>
 * �첽����ͨ��AsyncContext��������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
// ��ϣ�������첽���õ�Servlet���ԣ���Ҫ��ʽָ�������첽���ã���ʹ��@WebServlet��asyncSupported���Ի�����web.xml�н������á�
@WebServlet(name="async", urlPatterns={"/async"}, asyncSupported=true)
public class AsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		
		PrintWriter out = response.getWriter();
		out.println("<title>�첽����ʾ��</title>");
		out.println("����servlet��ʱ�� ��" + new Date() + "</br>");
		out.flush();
		
		// ����AsyncContext����ʼ�첽����
		AsyncContext async = request.startAsync();
		// Ϊ�첽����ע�������
		async.addListener(new MyAsyncListener());
		// �����첽���õĳ�ʱʱ��
		async.setTimeout(30 * 1000);
		// �����첽���õ��߳�
		async.start(new LongTask(async));
		
		out.println("����servlet��ʱ�� ��" + new Date() + "</br>");
		out.flush();
	}
}
