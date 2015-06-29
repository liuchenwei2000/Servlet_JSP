<%-- 
pageContext：javax.servlet.jsp.PageContext 的实例，该对象代表该JSP页面上下文。 
所以如果向某些辅助对象提供了一个 pageContext 引用，这些辅助对象就可以通过它得到其他隐式对象的引用以及所有作用域的属性。
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
使用 pageContext 可以访问/设置 page、request、session、application 范围的变量。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%
			// 取得 page 范围内的 name 属性 
			String name = (String) pageContext.getAttribute("name");
			// 取得 request 范围内的 age 属性，其他常量值有 PAGE_SCOPE、SESSION_SCOPE、APPLICATION_SCOPE
			String age = (String) pageContext.getAttribute("age", PageContext.REQUEST_SCOPE);
			// 使用 pageContext，即使不知道作用域也可以查找属性，范围顺序是：pageContext、request、session、application
			pageContext.findAttribute("wow");
			
			// pageContext还可用于获取其他内置对象，如下：
			pageContext.getRequest();// 获取request对象
			pageContext.getResponse();// 获取response对象
			pageContext.getServletConfig();// 获取config对象
			pageContext.getServletContext();// 获取application对象
			pageContext.getSession();// 获取session对象
			
			// 同理，还可以通过 pageContext 进行 setAttribute() 设值操作
		%>
	</body>
</html>

