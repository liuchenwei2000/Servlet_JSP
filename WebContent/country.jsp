<%@page contentType="text/html; charset=GBK" %>
<!DOCTYPE html>
<html>
<head>
<title>Return from server.</title>
</head>
<body>
	<%
		String country = (String) request.getAttribute("country");
		String area = (String) request.getAttribute("area");
		out.println("<h3>" + country + " area is " + area + "</h3>");
	%>
	<br><br>
	<br><br>
	<p>
		当前在线人数：<%=application.getAttribute("user_counter") %>
	</p>
</body>
</html>