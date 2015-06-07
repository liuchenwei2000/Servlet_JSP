<%-- page：代表该页面本身，也就是Servlet中的this，其类型就是生成的Servlet类，通常用处不大。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%= page.getClass().getName() %>
	</body>
</html>

