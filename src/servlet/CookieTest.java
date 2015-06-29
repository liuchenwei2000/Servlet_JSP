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
 * Cookie ���
 * <p>
 * ����ʹ�� cookie �ڷ������Ϳͻ�֮�佻����/ֵ�ԣ�string����cookie ʵ���Ͼ����ڿͻ��ͷ�����֮�佻����һС�����ݡ�
 * �������Ȱ� cookie ���͸��ͻ����ͻ�������һ������ʱ�ٰ� cookie ���ظ���������
 * cookie ��һ����ǣ��û����ؽ��룬cookie�������Զ���ɵģ�ǰ���ǿͻ���֧��cookie����
 * Ĭ�ϵأ�cookie��Ự������һ������һ���ͻ��뿪�������cookie�ͻ���ʧ��
 * ���ǿ�����cookie��ĸ���һЩ��������������Ѿ��رպ��Դ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class CookieTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * ��ӦGET����
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �ӿͻ�����õ� cookie������ cookie��
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {// ֻ��ͨ�������ķ�ʽ������Ҫ���Ǹ� cookie
			if ("username".equalsIgnoreCase(cookie.getName())) {
				String userName = cookie.getValue();
				System.out.println("Hello " + userName);
				break;
			}
		}

		// ����һ���� Cookie����ֵ��
		Cookie cookie = new Cookie("email", "aaa@gmail.com");
		// ���� cookie �ڿͻ����ϵĴ��ʱ�䣬��λ����
		cookie.setMaxAge(30 * 60);
		// �� cookie ���͸��ͻ������Է��Ͷ�� cookie
		resp.addCookie(cookie);
	}
}
