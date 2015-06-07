<%-- application：javax.servlet.ServletContext的实例，该实例代表JSP所属的Web应用本身。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
该对象通常有两个用途：

1，在整个Web应用的多个JSP、Servlet之间共享数据。
一旦将数据放入application中，它就可以被该应用下的所有JSP、Servlet访问。

2，访问Web应用的配置参数。
通过这种方式，可以将一些配置信息放在web.xml文件中，避免使用硬编码方式写在代码里，从而提高可移植性。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 常用方法有 getAttribute(String)、setAttribute(String,String)、getInitParameter(String)等。 --%>
		<%
			// 详见 web.xml 中的定义
			String url = application.getInitParameter("url");
			String pw = application.getInitParameter("password");
			
			application.setAttribute("name", "John");
			
			String name = (String) application.getAttribute("name");
		%>
	</body>
</html>

