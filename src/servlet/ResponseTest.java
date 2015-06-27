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
 * ��Ӧ��response�����
 * <p>
 * ���������£�ʹ����Ӧֻ��Ϊ����ͻ��������ݣ������Ӧ�������������� 
 * setContentType() ��  getWriter()/getOutputStream��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class ResponseTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ӦGET����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * ����������Ҫ���������������Щʲô�����������������ȷ��չ����Ӧ����������һ������Ӧ�ã�
		 * ��PDF�Ķ�������Ƶ��������Ҳ�������û�����HTML�����߰���Ӧ���ֽڱ���Ϊһ�������ļ��ȡ�
		 * 
		 * �������� ContentType ָ�ľ���MIME���ͣ�����HTTP��Ӧ�б����е�һ����Ϣ��
		 * 
		 * ����MIME�����У�text/html��application/pdf��video/quicktime��image/jpeg��application/jar��
		 */
		resp.setContentType("image/png");

		// "/" ��ʾWebӦ�õĸ�
		InputStream is = getServletContext().getResourceAsStream("/images/cross.png");

		int len = 0;
		byte[] buffer = new byte[1024 * 4];

		/*
		 * ServletResponse �ӿ�ֻ�ṩ���������ɹ�ѡ�� 
		 * PrintWriter���ַ�����ʹ������ println() ����д���ݡ�
		 * ServletOutputStream���ֽ�����ʹ������ write() ����д���ݡ�
		 */
		ServletOutputStream outputStream = resp.getOutputStream();
		while ((len = is.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}

		outputStream.flush();
		outputStream.close();
	}
	
	/**
	 * ��ӦPOST����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// forward ������ת�����Ƿ���������ת
		RequestDispatcher dispatcher = req.getRequestDispatcher("country.jsp");
		dispatcher.forward(req, resp);
		
		// sendRedirect ����Ӧ�ض����ǿͻ�����ת
		// ����ʹ����� URL ��Ϊ���������������ͣ�ǰ��û��б�ߺ���б�ߣ�"/"��
		// û��б�ߵ� URL �������������ԭ�ȵ����� URL ���������� URL ����
		// ԭ�������ַ�� http://localhost/app1/foo.do������ĵ��û��ض��� http://localhost/app1/test/bar.do
		resp.sendRedirect("test/bar.do");
		
		// ��б�ߵ�URL�����б����ζ�š�Web�����ĸ���������������� Web Ӧ�ñ�����������URL�����������������ԭ����URL����
		// ԭ�������ַ�� http://localhost/app1/foo.do������ĵ��û��ض��� http://localhost/test/bar.do
		// test ����һ���б��� app1 ��Ӧ��
		resp.sendRedirect("/test/bar.do");
	}
}
