/**
 * 
 */
package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * ServletContextAttributeListenerʾ��
 * <p>
 * ServletContextAttributeListener���ڼ���ServletContext��Χ�����Եĸı䡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	/**
	 * �������� ServletContext �������ʱ������
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
	}

	/**
	 * ������� ServletContext ɾ������ʱ������
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
	}

	/**
	 * �������滻 ServletContext �е�����ʱ������
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
	}
}
