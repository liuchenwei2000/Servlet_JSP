/**
 * 
 */
package ws;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

/**
 * ����webservice�ļ�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��5��21��
 */
public class WSServer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Endpoint.publish("http://localhost:8888/helloworld", new WebServiceImpl());
	}
}
