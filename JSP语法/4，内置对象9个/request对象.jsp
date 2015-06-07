<%-- request：javax.servlet.http.HttpServletRequest 的实例，该对象封装了一次请求，客户端请求参数都被封装在该对象里，获取客户端请求参数必须使用该对象。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 1，获取请求头/请求参数。 --%>
		<%
			// 获取所有请求头的名称
			java.util.Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = (String) headerNames.nextElement();
				// 获取单个请求头
				System.out.println(request.getHeader(headerName));
			}
			// 设置解码方式，对于简体中文使用 GBK
			request.setCharacterEncoding("GBK");
			// 获取请求参数的值
			String name = request.getParameter("name");
			// 获取请求参数的所有值（如果参数有多个值）
			String[] list = request.getParameterValues("list");
		%>
		
		<%-- 2，操作request范围属性。 --%>
		<%
			request.setAttribute("name", "John");
			// 获取请求参数的值
			String name2 = (String) request.getAttribute("name");
		%>
		
		<%-- 3，执行forward和include。也就是代替JSP所提供的forward和include动作命令。 --%>
		<%
			// path字符串必须以 斜线 开头
			RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		    dispatcher.forward(request, response);// 执行 forward
		    dispatcher.include(request, response);// 执行 include
		%>
	</body>
</html>

