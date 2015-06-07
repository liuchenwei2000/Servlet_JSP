/**
 * 
 */
package async;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 * 异步监听器示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月16日
 */
public class MyAsyncListener implements AsyncListener {

	/**
	 * 当异步调用开始时触发
	 */
	public void onStartAsync(AsyncEvent arg0) throws IOException {
		System.out.println("异步调用开始：" + new Date());
	}
	
	/**
	 * 当异步调用结束时触发
	 */
	public void onComplete(AsyncEvent arg0) throws IOException {
		System.out.println("异步调用结束：" + new Date());
	}

	/**
	 * 当异步调用出错时触发
	 */
	public void onError(AsyncEvent arg0) throws IOException {
		System.out.println("异步调用出错：" + new Date());
		arg0.getThrowable().printStackTrace();
	}

	/**
	 * 当异步调用超时时触发
	 */
	public void onTimeout(AsyncEvent arg0) throws IOException {
		System.out.println("异步调用超时：" + new Date());
	}
}
