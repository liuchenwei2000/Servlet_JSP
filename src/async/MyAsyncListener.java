/**
 * 
 */
package async;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 * �첽������ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��16��
 */
public class MyAsyncListener implements AsyncListener {

	/**
	 * ���첽���ÿ�ʼʱ����
	 */
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("�첽���ÿ�ʼ��" + new Date());
	}
	
	/**
	 * ���첽���ý���ʱ����
	 */
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("�첽���ý�����" + new Date());
	}

	/**
	 * ���첽���ó���ʱ����
	 */
	public void onError(AsyncEvent arg0) throws IOException {
		System.out.println("�첽���ó���" + new Date());
		arg0.getThrowable().printStackTrace();
	}

	/**
	 * ���첽���ó�ʱʱ����
	 */
	public void onTimeout(AsyncEvent arg0) throws IOException {
		System.out.println("�첽���ó�ʱ��" + new Date());
	}
}
