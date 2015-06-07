/**
 * 
 */
package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * һ�������Ե��Զ����ǩ��
 * <p>
 * �����Ա�ǩ����Ϊÿ�������ṩ��Ӧ��setter��getter������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��11��
 */
public class WithAttributeTag extends SimpleTagSupport {

	private String cases;
	
	@Override
	public void doTag() throws JspException, IOException {
		if ("upper".equalsIgnoreCase(getCases())) {
			getJspContext().getOut().write("HELLO WORLD.");
		} else {
			getJspContext().getOut().write("hello world.");
		}
	}

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}
}
