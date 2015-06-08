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
 * servletʾ��
 * <p>
 * Servletͨ������Ϊ��������С�����������ڷ������˵ĳ������ڴ�����Ӧ�ͻ��˵�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class ServletTest extends HttpServlet {// ����̳�HttpServlet

	private static final long serialVersionUID = 1L;

	/**
	 * ͨ��������д����������������������Ҫ��ʼ��Servletʱ�����ĳЩ��Դ��ʼ���ķ������ſ�����дinit������
	 * �����Ҫ������Servlet֮ǰ�������ĳЩ��Դ�Ļ��գ�����ر����ݿ����ӣ�����Ҫ��дdestroy������
	 */
	
	/**
	 * ��ʼ����������init�����ж����ǹ��췽����
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);// ��Ҫ���ȵ��ø���init����
		System.out.println("init complete");
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
	
	/**
	 * ��������Ӧ�ͻ�������ķ���
	 */
	
	/**
	 * ��ӦGET����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ����ͨ��ServletConfig��ȡ���õĲ���
		ServletConfig servletConfig = getServletConfig();
		String id = servletConfig.getInitParameter("id");
		String password = servletConfig.getInitParameter("password");
		System.out.println("id=" + id);
		System.out.println("password=" + password);

		// ����ķ�ʽ���Ի�ȡ��ǰӦ���ڷ������ϵľ���·��
		String realPath = getServletContext().getRealPath("");
		System.out.println("servlet real path=" + realPath);
	}

	/**
	 * ��ӦPOST����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	/**
	 * ��ӦDELETE����
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	/**
	 * ��ӦPUT����
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
}
