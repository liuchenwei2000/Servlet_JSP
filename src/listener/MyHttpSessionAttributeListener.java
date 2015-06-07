/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * HttpSessionAttributeListener示例
 * <p>
 * HttpSessionAttributeListener用于监听HttpSession范围内属性的改变。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * 当程序向 ServletContext 添加属性时触发。
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
	}

	/**
	 * 当程序从 ServletContext 删除属性时触发。
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	}

	/**
	 * 当程序替换 ServletContext 中的属性时触发。
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}
}
