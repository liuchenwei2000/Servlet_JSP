/**
 * 
 */
package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 4����ҳ��Ƭ�Σ�fragment����Ϊ���Եı�ǩ��
 * <p>
 * JSP2�淶������ֱ�ӽ�һ��ҳ��Ƭ����Ϊ���ԣ��ṩ�˸��������ԡ�
 * <p>
 * �������͵ı�ǩ����ͨ��ǩ���𲢲���ֻ�������򵥵ĸı䣺
 * 1����ǩ�������ж�������Ϊ JspFragment �����ԣ������Դ��� ҳ��Ƭ�Ρ�
 * 2��ʹ�ñ�ǩ��ʱ��ͨ��<jsp:attribute ../>����ָ��Ϊ��ǩ������ָ��ֵ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��11��
 */
public class FragmentTag extends SimpleTagSupport {// ����̳��� SimpleTagSupport

	private JspFragment content;
	
	/**
	 * ��дdoTag()���������������������ҳ������
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		// Ϊ fragment ���һ���߿�
		out.println("<div style='border:solid black;border-radius:15px;'>");
		// ������� fragment ����
		getContent().invoke(null);
		out.println("</div>");
	}

	public JspFragment getContent() {
		return content;
	}

	public void setContent(JspFragment content) {
		this.content = content;
	}
}
