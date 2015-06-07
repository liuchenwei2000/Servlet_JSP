/**
 * 
 */
package async;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 模拟耗时任务
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月16日
 */
public class LongTask implements Runnable {
	
	private AsyncContext async;

	public LongTask(AsyncContext async) {
		this.async = async;
	}

	public void run() {
		try {
			Thread.sleep(3000);// 暂停3秒
			
			List<String> books = new ArrayList<String>();
			books.add("Thinking in Java");
			books.add("Thinking in C++");
			books.add("Thinking in PHP");
			
			HttpServletRequest request = (HttpServletRequest) async.getRequest();
			request.setAttribute("books", books);
			
			async.dispatch("/async.jsp");
			async.complete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
