/**
 * 
 */
package filter.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 日志过滤器Filter示例
 * <p>
 * Filter 可以修改一个 request/response。它不是servlet，不能产生一个 response，
 * 它能够在一个 request 到达 servlet 之前对其进行预处理，也可以在离开 servlet 后对 response 进行后处理。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年6月1日
 */
public class LogFilter implements Filter {

	/** 
	 * Filter初始化时
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("【LogFilter init】");
	}
	
	/** 
	 * Filter被销毁时（一般是Web容器 shutdown的时候）
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("【LogFilter destroy】");
	}

	/** 
	 * 进行过滤操作
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("请求来源IP： " + req.getRemoteAddr());
		// 继续向后传递请求，直到目标Servlet处理完毕才返回
		chain.doFilter(req, resp);
		System.out.println("请求处理完毕！ ");
	}
}
