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
 * 多线程访问 Servlet 实例时如何安全销毁 Servlet
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年6月18日
 */
public class ShutdownExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1754718382987310869L;

	// 线程计数器，记录有多少个线程正在执行本 servlet 的 service() 方法
	private int counter = 0;
	// 本 servlet 是否已被要求 Shutdown
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
		// 模拟长时间任务执行时，要不断检查 isShuttingDown 标志
		while(!isShuttingDown()){
			// do something 
		}
	}

	/** 
	 * 确保所有执行本 servlet.service() 方法的线程全部退出之后才真正停止本 servlet
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		// 检查是否还有线程执行 servlet.service() 方法，有的话使用 isShuttingDown 标志通知它们停止
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
