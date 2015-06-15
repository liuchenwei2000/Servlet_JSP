<%@ page contentType="text/html;charset=GBK" language="java" %>

<!-- 
taglib 指令用于声明一个标签的引用，在JSP页面之中声明了哪个标签库的引用，即可在JSP页面中调用哪个标签。

taglib的语法格式如下：
prefix 属性：指定标签库前缀，即JSP页面中所有使用该前缀的标签将由此标签库处理。 
uri 属性：确定标签库的URI，与tld文件中的uri对应。
-->
<%@ taglib prefix="mytag" uri="http://taglib.mytag.com" %>
<!-- 引入 JSTL 核心标签库 -->
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<% 
			java.util.List<String> list = new java.util.ArrayList<String>();
			list.add("A");
			list.add("B");
			list.add("C");
			// 将 List 对象放入 page 范围内
			pageContext.setAttribute("a", list);
		%>
		<p>
			<!-- 使用标签，格式如 tagPrefix:tagName... -->
			<mytag:helloworld />
			<!-- 使用带属性的标签，并为属性设置 -->
			<mytag:withAttribute cases="upper" />
			<!-- 使用带标签体的标签 -->
			<mytag:iterator collection="a" item="item" >
				<tr>
					<td>${pageScope.item}</td>
				</tr>
			</mytag:iterator>
		</p>
	</body>
</html>

