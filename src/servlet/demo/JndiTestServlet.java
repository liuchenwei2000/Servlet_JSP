/**
 * 
 */
package servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * JNDI����Servlet
 * <p>
 * JNDI��Դ��META-INF/context.xml�С�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class JndiTestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1817591518049456312L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection connection = null;
		try {
			// ��ʼ�����������ռ�
			Context context = new InitialContext();
			// �ҵ� DataSource�������ƽ��ж�λjava:comp/env�Ǳ���ӵģ��������Դ��
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/test");
			
			connection = ds.getConnection();
			boolean result = testConnextion(connection);
			
			PrintWriter writer = resp.getWriter();
			if (result) {
				writer.write("DataSource connection OK");
			} else {
				writer.write("DataSource connection faild");
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean testConnextion(Connection connection) {
		Statement stat = null;
		try {
			stat = connection.createStatement();
			return stat.execute("SELECT 1");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
