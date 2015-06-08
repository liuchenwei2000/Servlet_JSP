<%-- 
request：javax.servlet.http.HttpServletRequest 的实例，该对象封装了一次请求。
客户端请求参数都被封装在该对象里，通常用于获取客户端请求参数、Cookie数据等。 
--%>
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
		
		<%-- 4，获取客户端/服务器端信息。 --%>
		<%
			request.getProtocol();// 获取客户端向服务器发送请求的协议
			request.getMethod();// 获取客户端向服务器传送数据的方法
			request.getRemoteHost();// 获取客户端主机名
			request.getRemoteAddr();// 获取客户端向IP地址
			request.getServerName();// 获取服务器名
			request.getServerPort();// 获取服务器端口号
			request.getServletPath();// 获取所请求的脚本文件的路径
		%>
		
		<!-- 
		当通过超链接的形式发送请求时可以同时传递参数，在超链接的后面加上"?"来实现。
		如下发送一个请求到delete.jsp页面并传递一个名为id，值为1的参数。
		-->
		<a href="delete.jsp?id=1">Delete</a>
		
		<!--  
		通过?指定请求参数时，参数值不需要使用单引号或双引号，包括字符型的参数。如果同时指定多个参数，各参数间使用符号"&"分隔。 
		如下发送一个请求到匹配deleteservlet.do的servlet，参数有code和name，值为2001和tom。
		-->
		<a href="deleteservlet.do?code=2001&name=tom">Delete</a>
	</body>
</html>
