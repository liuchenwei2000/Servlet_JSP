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
 * �Ự��HttpSession�����
 * <p>
 * HttpSession ������Ա����ͬһ���ͻ��������ĻỰ״̬��Ҳ����˵����һ���ض��ͻ��������Ự�ڼ䣬HttpSession ��־ô洢��
 * ���ڻỰ�ڼ�ͻ������������󣬴��еõ���������Ϣ�������� HttpSession ���󱣴档
 * <p>
 * HTTP Э��ʹ�õ�����״̬���ӣ����������ԣ�ÿ������������һ���µĿͻ���
 * �ͻ���Ҫһ��Ψһ�ĻỰID���Կͻ��ĵ�һ����������������һ��Ψһ�ĻỰID����ͨ����Ӧ�������ظ��ͻ���
 * �ͻ������Ժ��ÿһ�������з�������ỰID����������ID�󣬾ͻ��ҵ�ƥ��� HttpSession ���󣬲���������������������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class HttpSessionTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ����������ĳ�ַ�ʽ�ѻỰID��Ϊ��Ӧ��һ���ֽ����ͻ������ͻ�����ѻỰID��Ϊ�����һ���ַ��ء�
	 * ��򵥶�����õķ�ʽ��ͨ�� Cookie ��������ỰID��Ϣ������ HTTP ��Ӧ���ײ������� 
	 * Set-Cookie:JSESSIONID=0ADCD1245E ��������Ϣ�����ͻ�������ײ�Ҳ������ Cookie:JSESSIONID=0ADCD1245E ��������Ϣ��
	 * 
	 * ʵ���ϣ������������� cookie �����й�������ȷʵ������������봴����ʹ��һ���Ự��ͨ������ request.getSession() ��������
	 * ����֮�⣬���ɻỰID�������µ�cookie���󡢰ѻỰID�ŵ�cookie�С���cookie����Ϊ��Ӧ��һ���ֵȹ�����������������
	 * ���ں���������������������е�cookie�õ��ỰID��������ỰID��һ�����еĻỰƥ�䣬���ѻỰ�뵱ǰ���������
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		
		PrintWriter writer = resp.getWriter();
		if(session.isNew()) {// �ж� session �Ƿ����½���
			writer.println("session is new.");
		} else {
			writer.println("session is not new.");
		}
		
		// ���ص�һ�δ����Ự��ʱ�䡣
		session.getCreationTime();
		// �����������һ�εõ���������ỰID��������ȥ�˶೤ʱ�䣨���룩��
		session.getLastAccessedTime();
		// �Ự��������������ʱ���ڻỰ�����ϵ��� invalidate()��Ӧ�ý�����
		// ָ����������Ự���ͻ���������ʱ�������룩������ʱʱ�ޡ�
		session.setMaxInactiveInterval(20 * 60);
		session.getMaxInactiveInterval();
		// �����Ự����ǰ�洢�ڻỰ�е����лỰ����Ҳ�����󶨡�
		session.invalidate();
		
		writer.flush();
		writer.close();
	}

	/**
	 * ����ͻ�����cookie����������ͻ����"Set-Cookie"��Ӧ�ײ������ֻ�ܲ���URL��д�ˡ�
	 * URL��д��ȡ������cookie�еĻỰID�����ѻỰID���ӵ�����Ӧ�õĸ���URL�����
	 * ���� HTTP ��Ӧ���ص� HTML ������� <a href="http://localhost/myapp/login.do;JSESSIONID=0ADCD1245E">click</a>��
	 * ���ͻ������󽫱�� GET /myapp/login.do;JSESSIONID=0ADCD1245E ���зֺŷָ�������ͳһ�ģ���ͬ�Ŀ������в�ͬ�ķָ�����
	 * 
	 * ��������֪�� cookie �Ƿ�����������ͻ����ص�һ����Ӧʱ������ͬʱ���� cookie �� URL ��д����������
	 * URL ��дֻ�Զ�̬���ɵ�ҳ�棨����JSP����Ч���Ծ�̬��HTMLҳ������Ч�ġ�
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		req.getSession();

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		// ����ͻ������� cookie��URL ��д���Զ���������������ʽ�Ķ����� URL ����
		// �� URL ���Ӷ���ĻỰID��Ϣ
		writer.println(" <a href=\"" + resp.encodeURL("/sdemo.do") + "\">click</a>");
		writer.println("</body></html>");
		writer.flush();
		
		// �����������ض�������һ��URL������ʹ��ͬһ���Ự����Ҫʹ�����·�ʽ��
//		resp.encodeRedirectURL("/sdemo.do");
	}
}
