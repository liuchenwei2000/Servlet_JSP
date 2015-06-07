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
 * MVC֮Controller
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
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
		// ��ȡ�ͻ����ύ�Ĳ���
		String country = req.getParameter("country");
		// ���� Model��ִ��ҵ���߼�����
		CountryHelper helper = new CountryHelper();
		String area = helper.getArea(country);

		// ʹ��request���󱣴�����/ֵ��������View������Ϣ
		req.setAttribute("area", area);
		req.setAttribute("country", country);
		
		// ������������ת����ת����View
		RequestDispatcher dispatcher = req.getRequestDispatcher("country.jsp");
		dispatcher.forward(req, resp);
	}
}
