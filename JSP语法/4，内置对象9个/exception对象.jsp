<%-- exception：java.lang.Throwable 的实例，该实例代表其他页面中的异常和错误。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" isErrorPage="true" %>
<%-- 
只有当页面是错误处理页面，即编译指令page的isErrorPage属性为true时，该对象才可使用。
另外，JSP的声明部分依然需要自己处理异常，JSP异常处理机制只对_jspService()方法里的代码起作用。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 常用方法有 getMessage() 等。 --%>
		<%= exception.getMessage() %>
	</body>
</html>

