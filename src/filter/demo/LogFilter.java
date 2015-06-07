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
 * ��־������Filterʾ��
 * <p>
 * Filter �����޸�һ�� request/response��������servlet�����ܲ���һ�� response��
 * ���ܹ���һ�� request ���� servlet ֮ǰ�������Ԥ����Ҳ�������뿪 servlet ��� response ���к���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class LogFilter implements Filter {

	/** 
	 * Filter��ʼ��ʱ
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��LogFilter init��");
	}
	
	/** 
	 * Filter������ʱ��һ����Web���� shutdown��ʱ��
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("��LogFilter destroy��");
	}

	/** 
	 * ���й��˲���
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("������ԴIP�� " + req.getRemoteAddr());
		// ������󴫵�����ֱ��Ŀ��Servlet������ϲŷ���
		chain.doFilter(req, resp);
		System.out.println("��������ϣ� ");
	}
}
