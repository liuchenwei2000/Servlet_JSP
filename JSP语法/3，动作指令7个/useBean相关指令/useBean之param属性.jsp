<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
�������ֱ�Ӵ� html �� JSP��û�о��� servlet��JSP����β�ʹ�� sriptlet �����ܶ� bean ���Խ��и�ֵ��
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		
		<!-- ʹ�� scriptlet �ķ�ʽ�� bean ���Խ��и�ֵ -->
		<jsp:useBean id="user0" class="javabean.User">
			<jsp:setProperty name="user0" property="name" value="<%=request.getParameter(\"name\") %>" />
			<jsp:setProperty name="user0" property="age" value="<%= Integer.parseInt(request.getParameter(\"age\")) %>" />
		</jsp:useBean>
	
		<!-- ����ȫ���������� param ���԰� bean ������ֵ����Ϊһ�����������ֵ��ֻ��Ҫָ��������� -->
	
		<jsp:useBean id="user1" class="javabean.User">
			<jsp:setProperty name="user1" property="name" param="name" />
			<!-- 1��param="age" �� age �� html ��������� name ����ֵ��Ӧ -->
			<!-- 
			��� bean �������� String ���ͻ������������ͣ������ܹ��Զ��������ǿ��ת����
			<jsp:setProperty> ����ȡ��������� String ֵ������ת��Ϊһ�� int���ٰ���� int ���������Ե���Ӧ setter ��
			�����ʹ�� scriptlet �Ļ����򲻻��Զ���� String ���������͵�ת������ʹ���ʽ�� <jsp:setProperty> �����Ҳ���С�
			-->
			<jsp:setProperty name="user1" property="age" param="age" />
		</jsp:useBean>
		
		<jsp:useBean id="user2" class="javabean.User">
			<!-- 2����������еĲ������� bean ��������ȫƥ�䣬�Ͳ���Ҫ��  <jsp:setProperty> �����Ϊ������ָ��ֵ���������Զ�ƥ�䡣-->
			<jsp:setProperty name="user2" property="name" />
			<jsp:setProperty name="user2" property="age"/>
		</jsp:useBean>
		
		<jsp:useBean id="user3" class="javabean.User">
			<!-- 3����������еĲ������� bean ����������������ȫƥ�䣬����ʹ������ķ�ʽ������Ϊ���������Զ���ֵ��-->
			<jsp:setProperty name="user3" property="*" />
		</jsp:useBean>
	</body>
</html>