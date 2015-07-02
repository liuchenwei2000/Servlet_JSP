<%-- useBean、setProperty、getProperty这三个指令都是与JavaBean相关的。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
useBean 指令用于在JSP页面中声明和初始化一个 bean 属性；
setProperty 指令用于为JavaBean实例的属性设值；
getProperty 指令用于获取JavaBean实例的属性。
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
		其中 id 属性是 JavaBean 的实例名，class 属性指定 JavaBean 的完全限定类名，scope 属性用于指定 JavaBean 实例的作用范围，该范围有以下4个值：
		page：本页面有效。（默认作用域）
		request：本次请求有效。
		session：本次session有效。
		application：本应用有效。
		-->
		<!-- 
		如果在 指定作用域（本例是 page）范围内找不到一个名为 "mybean" 的属性对象，容器就会创建一个新实例，
		然后把这个实例赋给 id 变量，同时把它设置为指定作用域（本例是 page）中的一个属性。 
		-->
		<jsp:useBean id="mybean" class="javabean.User" scope="page" />
		
		<!-- 
		JSP的setProperty指令的格式如下：
		其中 name 属性指定 JavaBean 的实例名（与上面 jsp:useBean 的 id 值匹配），property 属性指定待设置的属性名，value 属性指定待设置的属性值。
		-->
		<jsp:setProperty name="mybean" property="age" value="32" />
		
		<!-- JSP的getProperty指令的格式如下： -->
		<jsp:getProperty name="mybean" property="age" />
	</body>
</html>

