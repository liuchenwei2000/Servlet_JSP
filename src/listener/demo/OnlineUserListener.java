/**
 * 
 */
package listener.demo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线人数的Listener
 * <p>
 * 实现了 HttpSessionListener，对session的创建和销毁进行监听。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年6月1日
 */
public class OnlineUserListener implements HttpSessionListener {

	private int counter = 0;
	
	/** 
	 * session创建的时候
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("当前在线人数：" + ++counter);
		event.getSession().getServletContext().setAttribute("user_counter", counter);
	}

	/** 
	 * session销毁的时候
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("当前在线人数：" + --counter);
		event.getSession().getServletContext().setAttribute("user_counter", counter);
	}
}
