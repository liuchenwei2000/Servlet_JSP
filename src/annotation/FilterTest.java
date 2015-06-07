/**
 * 
 */
package annotation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 使用Annotation配置Filter示例
 * <p>
 * @WebFilter 用于部署Filter类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
@WebFilter
public class FilterTest implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			chain.doFilter(request, response);
	}

	public void destroy() {
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
