<%-- 
response：javax.servlet.http.HttpServletResponse 的实例，代表服务器对客户端的相应。 
通常用于重定向网页、设置HTTP响应报头和缓冲区配置等。
--%>
<%-- 通过 contentType 属性指定响应数据是图片 --%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.awt.image.*" %>
<%@page contentType="text/html" language="java" pageEncoding="GBK" %>
<%-- 
通常很少使用该对象直接响应，而是使用out对象，除非需要生成非字符响应。但out是JspWriter的实例，是字符流，无法输出非字符内容。
假如需要在JSP页面中动态生成一幅图或者输出一个PDF文档，使用out作为响应对象将无法完成，必须使用response作为响应输出。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%-- 1，response 生成非字符响应。 --%>
		<%
			// 让网页内容以指定的格式输出到浏览器中，常见格式有 text/html、text/plain、application/msword
		 	response.setContentType("image/png");
			BufferedImage image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
		    // 使用 image 进行绘图
		    javax.imageio.ImageIO.write(image, "png", response.getOutputStream());
		%>
		<!-- 使用这种临时生成图片的方式很容易实现网页上的图形验证码功能。 -->
		<img alt="验证码" src="img.jsp">
		
		<%-- 2，重定向。 --%>
		<%
			// 与forward不同的是，redirect（重定向）会丢失所有的请求参数和request范围的属性。
			// 因为重定向将生成第二次请求，与前一次请求不在同一个request范围内，所以发送第一次请求的请求参数和其request范围的属性全部丢失。
			response.sendRedirect("result.jsp");
		%>
		
		<%-- 
		3，增加Cookie。
		Cookie通常用于网站记录用户的某些信息，比如用户名等。一旦用户下次登录，网站可以获取用户的相关信息，根据这些信息可以提供更友好的服务。
		Cookie与session的不同之处在于：session会随浏览器的关闭而失效，但Cookie会一直存放在客户端机器上，除非超出Cookie的生命期限。
		Cookie 值不允许出现中文字符，如果确实需要的话，必须使用 java.net.URLEncoder 对中文字符进行编码再设为Cookie值，读取的时候使用
		java.net.URLDecoder 进行解码在使用。
		--%>
		<%
			String name = request.getParameter("username");
			Cookie cookie = new Cookie("username", name);
			cookie.setMaxAge(24 * 60 * 60);// Cookie对象生命期限24小时
			response.addCookie(cookie);// 向客户端增加Cookie
		%>
		<!-- 访问客户端 Cookie 使用request对象 -->
		<%
			// 获取本站在客户端保留的所有Cookie
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				// 找到感兴趣的 Cookie
				if(c.getName().equals("username")){
					out.println(c.getValue());
				}
			}
		%>
		
		<%-- 4，操作HTTP头信息。 --%>
		<%
			/**
			禁用缓存
			
			默认情况下，浏览器会缓存显示的网页内容。这样当用户再次访问相同的网页时，浏览器会判断网页是否有变化。
			如果没有变化，则直接显示缓存中的内容，这样可以提高网页的显示速度。对于一些安全性要求较高的网站，通常需要禁用缓存。
			*/ 
			response.setHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
		
			
			/**
			页面自动刷新
			*/ 
			response.setHeader("refresh", "10");// 每隔10秒自动刷新一次
			
			/**
			定时跳转网页
			*/ 
			response.setHeader("refresh", "5;URL=login.jsp");// 每隔十5秒自动跳转到指定页面
		%>
	</body>
</html>

