<%-- out：javax.servlet.JspWriter 的实例，该实例代表JSP页面的输出流，用于输出内容形成HTML页面。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
通常用于在页面上输出变量值及常量，一般在使用输出表达式的地方，都可以使用out对象来达到同样效果。
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
			out.println("Hello world.");
		%>
	</body>
</html>

