/**
 * 
 */
package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * ServletRequestAttributeListener示例
 * <p>
 * ServletRequestAttributeListener用于监听ServletRequest范围内属性的改变。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	/**
	 * 当程序向 ServletRequest 添加属性时触发。
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
	}

	/**
	 * 当程序从 ServletRequest 删除属性时触发。
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
	}

	/**
	 * 当程序替换 ServletRequest 中的属性时触发。
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
	}
}
