<%@ page contentType="text/html;charset=GBK" language="java" %>

<%-- 
����tag�ļ��б�ǩ����﷨���£�
prefix��֮ǰ�Զ����ǩtaglibָ���prefix������ȫһ��������ȷ����ǩǰ׺��
��tagdir��ǩ��·���´���˺ܶ�tag file��ÿ��tag file��Ӧһ����ǩ��
--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<% 
			java.util.List<String> list = new java.util.ArrayList<String>();
			list.add("A");
			list.add("B");
			list.add("C");
			request.setAttribute("bean", list);
		%>
		<p>
			<!-- ʹ�ñ�ǩ����ʽ�� tagPrefix:tagName... -->
			<tags: iterator list="bean" color="red" />
		</p>
	</body>
</html>

