/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListenerʾ��
 * <p>
 * HttpSessionListener���ڼ����û�session�Ŀ�ʼ�ͽ�����
 * ����ͨ����������ͳ��ϵͳ�������û�����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class MyHttpSessionListener implements HttpSessionListener {

	/**
	 * �ͻ�����������˻Ự��ʼ��HttpSessionʵ������ʼ��ʱ������
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
	}

	/**
	 * �ͻ�����������˻Ự������HttpSessionʵ��������ʱ������
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	}
}
