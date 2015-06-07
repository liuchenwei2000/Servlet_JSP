<%-- 
异常处理页 

isErrorPage：设置JSP页面是否是错误处理页。
--%>
<%@ page contentType="text/html;charset=GBK" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			错误提示
		</title>
	</head>
	<body>
		<p>
			系统出现异常：<%=exception.getMessage() %>
		</p>
	</body>
</html>

