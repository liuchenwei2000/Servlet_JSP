/**
 * 
 */
package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ServletRequestListenerʾ��
 * <p>
 * ServletRequestListener���ڼ����û�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyServletRequestListener implements ServletRequestListener {

	/**
	 * �û����󵽴ServletRequestʵ������ʼ��ʱ������
	 */
	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
	}
	
	/**
	 * �û����������ServletRequestʵ��������ʱ������
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
	}
}
