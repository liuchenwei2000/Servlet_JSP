/**
 * 
 */
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * ServletContextAttributeListener示例
 * <p>
 * ServletContextAttributeListener用于监听ServletContext范围内属性的改变。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	/**
	 * 当程序向 ServletContext 添加属性时触发。
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
	}

	/**
	 * 当程序从 ServletContext 删除属性时触发。
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
	}

	/**
	 * 当程序替换 ServletContext 中的属性时触发。
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
	}
}
