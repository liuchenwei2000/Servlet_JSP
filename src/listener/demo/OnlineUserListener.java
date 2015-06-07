/**
 * 
 */
package listener.demo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ͳ������������Listener
 * <p>
 * ʵ���� HttpSessionListener����session�Ĵ��������ٽ��м�����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class OnlineUserListener implements HttpSessionListener {

	private int counter = 0;
	
	/** 
	 * session������ʱ��
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("��ǰ����������" + ++counter);
		event.getSession().getServletContext().setAttribute("user_counter", counter);
	}

	/** 
	 * session���ٵ�ʱ��
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("��ǰ����������" + --counter);
		event.getSession().getServletContext().setAttribute("user_counter", counter);
	}
}
