<%@page contentType="text/html; charset=GBK" %>
<%@page import="java.util.*" %>
<!-- �����ǩ�⣬����ǩ���ָ��ǰ׺�������� -->
<%@ taglib uri="http://taglib.mytag.com" prefix="mt" %>
<!DOCTYPE html>
<html>
<head>
<title>Tag demo</title>
</head>
<body>
		<!-- ʹ���Զ����ǩ -->
		�򵥱�ǩ��<br><mt:helloworld />
		<br><br>
		�����Եı�ǩ<br><mt:withAttribute cases="upper" />
		<br><br>
		<%
		List<String> names = new ArrayList<String>();
		names.add("Tom");
		names.add("Ann");
		names.add("Peter");
		
		pageContext.setAttribute("list", names);
		%>
		����ǩ��ı�ǩ<br>
		<mt:iterator collection="list" item="item" >
				${pageScope.item}
			<br>		
		</mt:iterator>
</body>
</html>