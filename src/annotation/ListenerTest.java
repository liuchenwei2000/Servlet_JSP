/**
 * 
 */
package annotation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ʹ��Annotation����Listenerʾ��
 * <p>
 * @WebListener ���ڲ���Listener�ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
@WebListener
public class ListenerTest implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
