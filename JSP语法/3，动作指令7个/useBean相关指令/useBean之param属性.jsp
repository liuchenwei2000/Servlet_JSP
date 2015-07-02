<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
如果请求直接从 html 到 JSP，没有经过 servlet，JSP中如何不使用 sriptlet 而又能对 bean 属性进行赋值。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		
		<!-- 使用 scriptlet 的方式对 bean 属性进行赋值 -->
		<jsp:useBean id="user0" class="javabean.User">
			<jsp:setProperty name="user0" property="name" value="<%=request.getParameter(\"name\") %>" />
			<jsp:setProperty name="user0" property="age" value="<%= Integer.parseInt(request.getParameter(\"age\")) %>" />
		</jsp:useBean>
	
		<!-- 下面全部都是利用 param 属性把 bean 的属性值设置为一个请求参数的值，只需要指定请求参数 -->
	
		<jsp:useBean id="user1" class="javabean.User">
			<jsp:setProperty name="user1" property="name" param="name" />
			<!-- 1，param="age" 的 age 与 html 表单输入域的 name 属性值对应 -->
			<!-- 
			如果 bean 的属性是 String 类型或其他基础类型，容器能够自动完成类型强制转换。
			<jsp:setProperty> 动作取请求参数的 String 值，将其转换为一个 int，再把这个 int 传给该属性的相应 setter 。
			而如果使用 scriptlet 的话，则不会自动完成 String 到基本类型的转换，即使表达式在 <jsp:setProperty> 标记中也不行。
			-->
			<jsp:setProperty name="user1" property="age" param="age" />
		</jsp:useBean>
		
		<jsp:useBean id="user2" class="javabean.User">
			<!-- 2，如果请求中的参数名与 bean 属性名完全匹配，就不需要在  <jsp:setProperty> 标记中为该属性指定值，容器会自动匹配。-->
			<jsp:setProperty name="user2" property="name" />
			<jsp:setProperty name="user2" property="age"/>
		</jsp:useBean>
		
		<jsp:useBean id="user3" class="javabean.User">
			<!-- 3，如果请求中的参数名与 bean 的所有属性名都完全匹配，可以使用下面的方式让容器为所有属性自动赋值。-->
			<jsp:setProperty name="user3" property="*" />
		</jsp:useBean>
	</body>
</html>