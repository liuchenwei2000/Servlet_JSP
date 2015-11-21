/**
 * 
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Filter示例
 * <p>
 * 创建一个Filter只需两个步骤：
 * 1，创建Filter实现类。
 * 2，部署Filter（在web.xml中配置）。
 * <p>
 * Filter将会验证用户是否已登录，如果没有登录则直接跳转到登录页面。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class FilterTest implements Filter {// 必须实现Filter
	
	// 通常需要保存配置对象
	private FilterConfig config;

	/**
	 * 用于完成Filter的初始化
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}
	
	/**
	 * 用于Filter销毁前，完成某些资源的回收。
	 */
	@Override
	public void destroy() {
		this.config = null;
	}

	/**
	 * 核心方法：实现拦截过滤功能，该方法就是对每个请求及响应增加的额外处理。
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String loginPage = config.getInitParameter("loginPage");
		HttpSession session = ((HttpServletRequest)request).getSession(true);
		String servletPath = ((HttpServletRequest)request).getServletPath();
		
		// 这里放入一个user信息，假装已经登录
		session.setAttribute("user", "admin");
		// session 中没有user信息则认为尚未登录
		if (session.getAttribute("user") == null && !servletPath.endsWith(loginPage)) {
			request.setAttribute("提示", "您还没有登录。");
			// 直接跳转到登录界面，不再将请求向后传递
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			/* 
			 * Filter只是链式处理，请求依然被放行到目的地址。
			 * 假设容器能把请求 URL 映射到一个 servlet 或 JSP，那么 FilterChain 尾部总是一个 servlet 或 JSP。
			 */
			chain.doFilter(request, response);
		}
	}
}
