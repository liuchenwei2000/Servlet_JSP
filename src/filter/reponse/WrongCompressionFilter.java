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
 * �����ѹ����Ӧ Filter ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2015��6��1��
 */
public class WrongCompressionFilter implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	/**
	 * ������Ӧѹ������
	 * <p>
	 * ����ԭ��
	 * ��Ϊ chain.doFilter(req, resp) �����ĵ����Ѿ�����Ӧ���󴫵ݸ��� servlet��
	 * �� servlet ��������Ĺ�����ֱ�ӽ���Ӧ���ظ��˿ͻ�������������ѹ������Ѿ����ˡ�
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// �������������
		chain.doFilter(req, resp);
		// �������ѹ����Ӧ ���߼�
	}
}
