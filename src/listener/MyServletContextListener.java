/**
 * 
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener示例
 * <p>
 * ServletContextListener用于监听Web应用的启动和关闭。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyServletContextListener implements ServletContextListener {
	
	/**
	 * 回调方法来启动某些后台程序，这些后台程序负责为系统运行提供支持。
	 */
	
	/**
	 * 启动Web应用时被调用
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	}

	/**
	 * 关闭Web应用时被调用
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
