/**
 * 
 */
package taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 一个带属性的自定义标签类
 * <p>
 * 带属性标签必须为每个属性提供对应的setter和getter方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月11日
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
