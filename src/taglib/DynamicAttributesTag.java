/**
 * 
 */
package taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * ��̬���Ա�ǩ��
 * <p>
 * ǰ�漸�ֱ�ǩ�����Ը����ǹ̶��ģ�����������Եĸ������̶�������Ҫ������̬���Ա�ǩ��
 * <p>
 * �������͵ı�ǩ����ͨ��ǩ������������Ҫ��
 * 1����ǩ��������Ҫʵ�� DynamicAttributes �ӿڡ�
 * 2�����ñ�ǩʱͨ�� dynamic-attributes Ԫ��ָ����֧�ֶ�̬���ԡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��11��
 */
public class DynamicAttributesTag extends SimpleTagSupport implements DynamicAttributes {// ����ʵ�� DynamicAttributes �ӿ�
	
	// ��̬������
	private List<String> names = new ArrayList<String>();
	// ��̬����ֵ
	private List<String> values = new ArrayList<String>();

	/**
	 * ��дdoTag()���������������������ҳ������
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<ol>");
		for (int i = 0; i < names.size(); i++) {
			out.println("<li>" + names.get(i) + "=" + values.get(i) + "</li>");
		}
		out.println("</ol>");
	}

	/** 
	 * ʵ�� DynamicAttributes �еĸ÷�������̬���������������ֵ
	 * 
	 * @see javax.servlet.jsp.tagext.DynamicAttributes#setDynamicAttribute(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setDynamicAttribute(String uri, String localName, Object value)
			throws JspException {
		names.add(localName);
		values.add((String) value);
	}
}
