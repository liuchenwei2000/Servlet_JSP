/**
 * 
 */
package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * ServletRequestAttributeListenerʾ��
 * <p>
 * ServletRequestAttributeListener���ڼ���ServletRequest��Χ�����Եĸı䡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

	/**
	 * �������� ServletRequest �������ʱ������
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
	}

	/**
	 * ������� ServletRequest ɾ������ʱ������
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
	}

	/**
	 * �������滻 ServletRequest �е�����ʱ������
	 */
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
	}
}
