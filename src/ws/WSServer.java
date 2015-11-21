/**
 * 
 */
package ws;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.ws.Endpoint;

/**
 * 启动webservice的监听器
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月21日
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
