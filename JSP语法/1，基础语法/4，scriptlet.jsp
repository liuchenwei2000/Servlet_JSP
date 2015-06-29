<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
scriptlet 里可以包含任何可执行的Java代码，通常来说，可执行Java代码可以通过scriptlet嵌入到html页面。
scriptlet 中的代码会被嵌入到该 JSP 生成的 Servlet 类中的  _jspService() 方法中，成为局部变量和代码片段。
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
		int count = 0;
		for(int i=0; i<10; i++) {
			count += i;
		}
		out.println(count);
		%>

		<%
		for(int i=0; i<10; i++) {
			%>
			<p>
				<%=i%>
			</p>
			<%
		}
		%>
	</body>
</html>

