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
 * 4，以页面片段（fragment）作为属性的标签类
 * <p>
 * JSP2规范还允许直接将一段页面片段作为属性，提供了更大的灵活性。
 * <p>
 * 这种类型的标签与普通标签区别并不大，只有两个简单的改变：
 * 1，标签处理类中定义类型为 JspFragment 的属性，该属性代表 页面片段。
 * 2，使用标签库时，通过<jsp:attribute ../>动作指令为标签的属性指定值。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月11日
 */
public class FragmentTag extends SimpleTagSupport {// 必须继承自 SimpleTagSupport

	private JspFragment content;
	
	/**
	 * 重写doTag()方法，这个方法负责生成页面内容
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		// 为 fragment 添加一个边框
		out.println("<div style='border:solid black;border-radius:15px;'>");
		// 调用输出 fragment 自身
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
