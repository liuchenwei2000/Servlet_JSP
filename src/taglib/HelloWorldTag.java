/**
 * 
 */
package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * һ���򵥵��Զ����ǩ��
 * <p>
 * ��JSPҳ��ʹ��һ���򵥵ı�ǩʱ���ײ�ʵ�����ɱ�ǩ�������ṩ֧�֣�
 * �Ӷ�����ͨ���򵥵ı�ǩ����װ���ӵĹ��ܣ��Ӷ�ʹ�ŶӸ��õ�Э����������������JSPҳ��Ŀ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��11��
 */
public class HelloWorldTag extends SimpleTagSupport {// ����̳��� SimpleTagSupport

	/**
	 * ��дdoTag()���������������������ҳ������
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// ��ȡJSPҳ�������������ַ���
		getJspContext().getOut().write("Hello world.");
	}
}
