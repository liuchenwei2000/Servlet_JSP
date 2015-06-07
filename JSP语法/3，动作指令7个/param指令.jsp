<%-- param指令用于设置参数值，这个指令本身不能单独使用，必须与include、forward指令配合使用。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 当与include指令结合使用时，param指令用于将参数传入被导入的页面。 --%>
	    <jsp:include page="result.jsp">
			<jsp:param name="age" value="22" />
		</jsp:include>
		<%-- 当与forward指令结合使用时，param指令用于将参数值传入被转向的页面。 --%>
		<jsp:forward page="result.jsp">
			<jsp:param name="age" value="22" />
		</jsp:forward>
	</body>
</html>

