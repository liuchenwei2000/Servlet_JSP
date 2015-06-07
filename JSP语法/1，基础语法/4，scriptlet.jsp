<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
scriptlet里可以包含任何可执行的Java代码，通常来说，可执行Java代码可以通过scriptlet嵌入到html页面。
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

