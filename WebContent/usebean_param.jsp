<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			≤‚ ‘ useBean µƒ param  Ù–‘
		</title>
	</head>
	<body>
	
		<jsp:useBean id="user0" class="javabean.User">
			<jsp:setProperty name="user0" property="name" value="<%=request.getParameter(\"name\") %>" />
			<jsp:setProperty name="user0" property="age" value="<%= Integer.parseInt(request.getParameter(\"age\")) %>" />
		</jsp:useBean>
		
		User0 <%=user0.toString() %><br>
		Name£∫<jsp:getProperty name="user0" property="name" /><br>
		Age£∫<jsp:getProperty name="user0" property="age" /><br>
	
		<jsp:useBean id="user1" class="javabean.User">
			<jsp:setProperty name="user1" property="name" param="name" />
			<jsp:setProperty name="user1" property="age" param="age" />
		</jsp:useBean>
		
		<br><br>
		User1 <%=user1.toString() %><br>
		Name£∫<jsp:getProperty name="user1" property="name" /><br>
		Age£∫<jsp:getProperty name="user1" property="age" /><br>
		
		<jsp:useBean id="user2" class="javabean.User">
			<jsp:setProperty name="user2" property="name" />
			<jsp:setProperty name="user2" property="age"/>
		</jsp:useBean>
		
		<br><br>
		User2 <%=user2.toString() %><br>
		Name£∫<jsp:getProperty name="user2" property="name" /><br>
		Age£∫<jsp:getProperty name="user2" property="age" /><br>
		
		<jsp:useBean id="user3" class="javabean.User">
			<jsp:setProperty name="user3" property="*" />
		</jsp:useBean>
		
		<br><br>
		User3 <%=user3.toString() %><br> 
		Name£∫<jsp:getProperty name="user3" property="name" /><br>
		Age£∫<jsp:getProperty name="user3" property="age" /><br>
	</body>
</html>