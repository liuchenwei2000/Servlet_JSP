/**
 * 
 */
package annotation;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * ʹ��Annotation����Filterʾ��
 * <p>
 * @WebFilter ���ڲ���Filter�ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
@WebFilter(filterName = "filtertest", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "user", value = "tom"),
		@WebInitParam(name = "password", value = "111") }, 
		/** ���ø�Filter����ָ����ģʽ��������й��� */
		dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE })
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
