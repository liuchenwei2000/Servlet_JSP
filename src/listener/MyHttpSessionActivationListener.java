/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * HttpSessionActivationListener示例
 * <p>
 * HttpSessionActivationListener用于监听 HttpSession 何时从一个 VM 移到另一个 VM。
 * <p>
 * 只有 HttpSession 对象（及其属性）会从一个VM移到另一个VM。
 * 每个VM中有一个 ServletContext，每个VM上的每个 servlet 有一个ServletConfig，
 * 但是对于每个Web应用的一个给定的会话ID，只有一个 HttpSession 对象，而不论应用分布在多少个VM上。
 * 在任何给定时刻，会话只存在于一个位置，对于一个给定的Web应用，相同的会话ID不会同时出现在两个VM中。
 * 尽管应用的其他部分会在每个节点/VM上复制，但会话对象不会复制，而只是移动。
 * <p>
 * 本接口一般由属性类来实现。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年6月29日
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	
	/** 
	 * 当会话将要从原VM上钝化的时候
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// 将非 Serialiazable 字段置为某种状态，以便顺利地迁移到一个新VM
	}
	
	/** 
	 * 当会话将要从新VM上激活的时候
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// 这些代码用于恢复字段，取消在 sessionWillPassivate() 中做的动作。
	}
}
