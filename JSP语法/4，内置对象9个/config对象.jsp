<%-- config：javax.servlet.ServletConfig 的实例，该实例代表该JSP的配置信息。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
事实上JSP页面通常无需配置，也就不存在配置信息，所以该对象更多的在Servlet中有效。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 常用方法有 getInitParameter(String)、getInitParameters() 等。 --%>
		<%
		    // 详见 web.xml 中的定义
		    // 只有通过 url/jspconfig 访问时才能获取初始参数，通过  url/config对象.jsp 是无法访问初始参数的。
			String name = config.getInitParameter("name");
			String age = config.getInitParameter("age");
		%>
		<%-- 所有的JSP页面都有相同的servlet name：jsp --%>
		<%=config.getServletName() %>>
	</body>
</html>

