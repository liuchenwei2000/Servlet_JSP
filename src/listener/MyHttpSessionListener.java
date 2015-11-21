/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener示例
 * <p>
 * HttpSessionListener用于监听用户session的开始和结束。
 * 可以通过本监听器统计系统的在线用户数。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyHttpSessionListener implements HttpSessionListener {

	/**
	 * 客户端与服务器端会话开始，HttpSession实例被初始化时触发。
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	/**
	 * 客户端与服务器端会话结束，HttpSession实例被销毁时触发。
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
}
