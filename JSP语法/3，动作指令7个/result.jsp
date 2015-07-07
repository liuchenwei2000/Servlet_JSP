<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			结果页
		</title>
	</head>
	<body>
		<!-- 输出请求参数 -->
		Scriptlet方式输出请求参数：<%=request.getParameter("age") %>
		<p>
		EL 方式输出请求参数：${param.age}
	</body>
</html>

