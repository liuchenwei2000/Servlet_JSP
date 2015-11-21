/**
 * 
 */
package taglib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 1，一个简单的自定义标签类
 * <p>
 * 在JSP页面使用一个简单的标签时，底层实际上由标签处理类提供支持，
 * 从而可以通过简单的标签来封装复杂的功能，从而使团队更好地协作开发（美工参与JSP页面的开发）。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月11日
 */
public class HelloWorldTag extends SimpleTagSupport {// 必须继承自 SimpleTagSupport

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	/**
	 * 重写doTag()方法，这个方法负责生成页面内容
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// 获取JSP页面输出流并输出字符串
		getJspContext().getOut().println("Hello world. Now is " + formatter.format(new Date()));
	}
}
