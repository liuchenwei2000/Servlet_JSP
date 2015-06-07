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
 * �ַ����������
 * <p>
 * ʹ��ָ���ַ�����request/response���б��롣
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class CharacterEncodingFilter implements Filter {
	
	private FilterConfig filterConfig;
	
	private String encoding;
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		this.encoding = filterConfig.getInitParameter("encoding");
		System.out.println("��CharacterEncodingFilter init��");
	}
	
	@Override
	public void destroy() {
		System.out.println("��CharacterEncodingFilter destroy��");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("encoding=" + this.encoding);
		// �� �������Ӧ �����ַ�������
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
	}
}
