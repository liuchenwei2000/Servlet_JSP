<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
scriptlet ����԰����κο�ִ�е�Java���룬ͨ����˵����ִ��Java�������ͨ��scriptletǶ�뵽htmlҳ�档
scriptlet �еĴ���ᱻǶ�뵽�� JSP ���ɵ� Servlet ���е�  _jspService() �����У���Ϊ�ֲ������ʹ���Ƭ�Ρ�
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

