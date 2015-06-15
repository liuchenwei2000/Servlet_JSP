/**
 * 
 */
package taglib;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 3��һ������ǩ����Զ����ǩ��
 * <p>
 * ����ǩ��ı�ǩ�������ڱ�ǩ��Ƕ���������ݣ�������̬��HTML���ݺͶ�̬��JSP���ݣ���
 * ͨ���������һЩ�߼����㣬���жϺ�ѭ���ȡ�
 * <p>
 * �ñ�ǩ�����ã�����ָ�����ϣ�ÿ����һ������Ԫ�أ��������ǩ��һ�Ρ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��10��11��
 */
public class WithBodyTag extends SimpleTagSupport {

	// ��ǩ���ԣ�����ָ���������ļ���
	private String collection;
	// ��ǩ���ԣ�����ָ����������Ԫ�ص�����	
	private String item;
	
	@Override
	public void doTag() throws JspException, IOException {
		// �� page scope�л�ȡ��Ϊ collection �ļ��϶���
		Collection<?> c = (Collection<?>) getJspContext().getAttribute(getCollection());
		for (Object element : c) {
			// ����ǰ������Ԫ�����õ� page scope �У��Ա�jspҳ��ʹ��
			getJspContext().setAttribute(item, element);
			// ���ظñ�ǩ�������ı�ǩ�壬ִ�иö����invoke()���������������ǩ�����ݡ�
			getJspBody().invoke(null);
		}
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
