/**
 * 
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListenerʾ��
 * <p>
 * ServletContextListener���ڼ���WebӦ�õ������͹رա�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyServletContextListener implements ServletContextListener {
	
	/**
	 * �ص�����������ĳЩ��̨������Щ��̨������Ϊϵͳ�����ṩ֧�֡�
	 */
	
	/**
	 * ����WebӦ��ʱ������
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	}

	/**
	 * �ر�WebӦ��ʱ������
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
