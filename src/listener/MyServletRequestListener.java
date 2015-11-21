/**
 * 
 */
package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ServletRequestListener示例
 * <p>
 * ServletRequestListener用于监听用户请求。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyServletRequestListener implements ServletRequestListener {

	/**
	 * 用户请求到达，ServletRequest实例被初始化时触发。
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
	}
	
	/**
	 * 用户请求结束，ServletRequest实例被销毁时触发。
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
	}
}
