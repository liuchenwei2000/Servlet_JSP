/**
 * 
 */
package taglib;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 3，一个带标签体的自定义标签类
 * <p>
 * 带标签体的标签，可以在标签内嵌入其他内容（包括静态的HTML内容和动态的JSP内容）。
 * 通常用于完成一些逻辑运算，如判断和循环等。
 * <p>
 * 该标签的作用：遍历指定集合，每遍历一个集合元素，即输出标签体一次。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月11日
 */
public class WithBodyTag extends SimpleTagSupport {

	// 标签属性，用于指定被迭代的集合
	private String collection;
	// 标签属性，用于指定迭代集合元素的名称	
	private String item;
	
	@Override
	public void doTag() throws JspException, IOException {
		// 从 page scope中获取名为 collection 的集合对象
		Collection<?> c = (Collection<?>) getJspContext().getAttribute(getCollection());
		for (Object element : c) {
			// 将当前迭代的元素设置到 page scope 中，以便jsp页面使用
			getJspContext().setAttribute(item, element);
			// 返回该标签所包含的标签体，执行该对象的invoke()方法，即可输出标签体内容。
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
