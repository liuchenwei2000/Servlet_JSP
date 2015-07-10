/**
 * 
 */
package filter.reponse;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 错误的压缩响应 Filter 示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2015年6月1日
 */
public class WrongCompressionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	/**
	 * 进行响应压缩操作
	 * <p>
	 * 错误原因：
	 * 因为 chain.doFilter(req, resp) 方法的调用已经把响应对象传递给了 servlet，
	 * 而 servlet 在完成它的工作后，直接将响应发回给了客户，过滤器再想压缩输出已经晚了。
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 这里进行请求处理
		chain.doFilter(req, resp);
		// 这里进行压缩响应 的逻辑
	}
}
