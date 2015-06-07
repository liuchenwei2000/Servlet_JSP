/**
 * 
 */
package annotation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 使用Annotation配置Listener示例
 * <p>
 * @WebListener 用于部署Listener类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
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
