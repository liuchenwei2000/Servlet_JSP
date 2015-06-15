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
 * 动态属性标签类
 * <p>
 * 前面几种标签的属性个数是固定的，如果传入属性的个数不固定，则需要借助动态属性标签。
 * <p>
 * 这种类型的标签比普通标签多了两个额外要求：
 * 1，标签处理类需要实现 DynamicAttributes 接口。
 * 2，配置标签时通过 dynamic-attributes 元素指定其支持动态属性。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月11日
 */
public class DynamicAttributesTag extends SimpleTagSupport implements DynamicAttributes {// 必须实现 DynamicAttributes 接口
	
	// 动态属性名
	private List<String> names = new ArrayList<String>();
	// 动态属性值
	private List<String> values = new ArrayList<String>();

	/**
	 * 重写doTag()方法，这个方法负责生成页面内容
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
	 * 实现 DynamicAttributes 中的该方法，动态添加属性名和属性值
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
