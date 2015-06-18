/**
 * 
 */
package servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���̷߳��� Servlet ʵ��ʱ��ΰ�ȫ���� Servlet
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��18��
 */
public class ShutdownExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1754718382987310869L;

	// �̼߳���������¼�ж��ٸ��߳�����ִ�б� servlet �� service() ����
	private int counter = 0;
	// �� servlet �Ƿ��ѱ�Ҫ�� Shutdown
	private boolean isShuttingDown;

	public synchronized void enteringServiceMethod() {
		counter++;
	}

	public synchronized void leavingServiceMethod() {
		counter--;
	}

	public synchronized int getCounter() {
		return counter;
	}
	
	public synchronized boolean isShuttingDown() {
		return isShuttingDown;
	}

	public synchronized void setShuttingDown(boolean isShuttingDown) {
		this.isShuttingDown = isShuttingDown;
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		enteringServiceMethod();
		try {
			super.service(arg0, arg1);
		} finally {
			leavingServiceMethod();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ģ�ⳤʱ������ִ��ʱ��Ҫ���ϼ�� isShuttingDown ��־
		while(!isShuttingDown()){
			// do something 
		}
	}

	/** 
	 * ȷ������ִ�б� servlet.service() �������߳�ȫ���˳�֮�������ֹͣ�� servlet
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		// ����Ƿ����߳�ִ�� servlet.service() �������еĻ�ʹ�� isShuttingDown ��־֪ͨ����ֹͣ
		if(getCounter() > 0) {
			setShuttingDown(true);
		}
		
		while (getCounter() > 0) {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("shutting down...");
	}
}
