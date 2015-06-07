<%-- useBean、setProperty、getProperty这三个指令都是与JavaBean相关的。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
useBean指令用于在JSP页面中初始化一个Java实例；
setProperty指令用于为JavaBean实例的属性设值；
getProperty指令用于获取JavaBean实例的属性。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<!-- 
		JSP的useBean指令的格式如下： 
		其中id属性是JavaBean的实例名，class属性指定JavaBean的实现类，scope属性用于指定JavaBean实例的作用范围，该范围有以下4个值：
		page：本页面有效。
		request：本次请求有效。
		session：本次session有效。
		application：本应用有效。
		-->
		<jsp:useBean id="mybean" class="login.User" scope="page" />
		
		<!-- 
		JSP的setProperty指令的格式如下：
		其中name属性指定JavaBean的实例名，property属性指定待设置的属性名，value属性指定待设置的属性值。
		-->
		<jsp:setProperty name="mybean" property="age" value="32" />
		
		<!-- JSP的getProperty指令的格式如下： -->
		<jsp:getProperty name="mybean" property="age" />
	</body>
</html>

