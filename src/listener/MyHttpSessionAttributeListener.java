/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * HttpSessionAttributeListenerʾ��
 * <p>
 * HttpSessionAttributeListener���ڼ���HttpSession��Χ�����Եĸı䡣
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * �������� ServletContext �������ʱ������
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
	}

	/**
	 * ������� ServletContext ɾ������ʱ������
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
	}

	/**
	 * �������滻 ServletContext �е�����ʱ������
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
	}
}
