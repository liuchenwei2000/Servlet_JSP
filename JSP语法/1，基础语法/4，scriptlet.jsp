<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
scriptlet����԰����κο�ִ�е�Java���룬ͨ����˵����ִ��Java�������ͨ��scriptletǶ�뵽htmlҳ�档
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%
		int count = 0;
		for(int i=0; i<10; i++) {
			count += i;
		}
		out.println(count);
		%>

		<%
		for(int i=0; i<10; i++) {
			%>
			<p>
				<%=i%>
			</p>
			<%
		}
		%>
	</body>
</html>

