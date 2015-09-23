<%-- forward 指令用于将对请求的处理转发到另外的页面，既可以是静态的html页面，也可以是动态的jsp页面，或者转发到容器中的servlet。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
执行forward指令转发请求时，用户请求的地址依然没有发生改变，但页面内容却完全变为转发后的目标页。
同时客户端的请求参数不会丢失，其实它并没有重新向新页面发送请求，只是完全采用了新页面来对用户生成响应。

需要注意的是，发生转发时，请求转发到的目标资源首先会清空响应缓冲区，即转发前写到响应的所有内容都会被清除掉。
另外，也不要先刷新输出再转发，这会造成 IllegalStateException。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<!-- JSP的forward指令的格式如下： -->
		<jsp:forward page="result.jsp">
			<!-- jsp:param 用于在增加额外的请求参数，参数值可以通过HttpServletRequest类的getParamter()方法获取。 -->
			<jsp:param name="age" value="22" />
		</jsp:forward>
	</body>
</html>

