/**
 * 
 */
package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * HttpSessionActivationListenerʾ��
 * <p>
 * HttpSessionActivationListener���ڼ��� HttpSession ��ʱ��һ�� VM �Ƶ���һ�� VM��
 * <p>
 * ֻ�� HttpSession ���󣨼������ԣ����һ��VM�Ƶ���һ��VM��
 * ÿ��VM����һ�� ServletContext��ÿ��VM�ϵ�ÿ�� servlet ��һ��ServletConfig��
 * ���Ƕ���ÿ��WebӦ�õ�һ�������ĻỰID��ֻ��һ�� HttpSession ���󣬶�����Ӧ�÷ֲ��ڶ��ٸ�VM�ϡ�
 * ���κθ���ʱ�̣��Ựֻ������һ��λ�ã�����һ��������WebӦ�ã���ͬ�ĻỰID����ͬʱ����������VM�С�
 * ����Ӧ�õ��������ֻ���ÿ���ڵ�/VM�ϸ��ƣ����Ự���󲻻Ḵ�ƣ���ֻ���ƶ���
 * <p>
 * ���ӿ�һ������������ʵ�֡�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��29��
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

	
	/** 
	 * ���Ự��Ҫ��ԭVM�϶ۻ���ʱ��
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// ���� Serialiazable �ֶ���Ϊĳ��״̬���Ա�˳����Ǩ�Ƶ�һ����VM
	}
	
	/** 
	 * ���Ự��Ҫ����VM�ϼ����ʱ��
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// ��Щ�������ڻָ��ֶΣ�ȡ���� sessionWillPassivate() �����Ķ�����
	}
}
