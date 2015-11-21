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
import javax.servlet.http.HttpServletRequest;

/**
 * 图片防盗链过滤器
 * <p>
 * 为了防止本站内的资源被其他网站盗链，可以使用过滤器完成防盗链的功能。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年6月8日
 */
public class ImageRedirectFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取请求是从哪个页面链接过来的，服务器可以获得此信息进行后续处理。
		String referer = ((HttpServletRequest) request).getHeader("Referer");
		String serverName = request.getServerName();
		
		System.out.println("【referer】" + referer + " 【servername】" + serverName);
		
		if (referer == null || !referer.contains(serverName)) {
			// 如果链接地址来自其他网站，则返回错误图片
			request.getRequestDispatcher("/images/error.png").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
