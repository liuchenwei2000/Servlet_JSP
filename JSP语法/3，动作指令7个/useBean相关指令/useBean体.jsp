<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
<jsp:useBean> �������塣
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
	
		<%--
		��������÷������루<jsp:setProperty>������ <jsp:useBean> �����У��������������������� property ֵ�ˡ�
		ֻ����ָ����Χ�������� request�����Ҳ��� bean ���Ҵ���һ���� bean ʱ�Ż�����������Ĵ��롣
		--%>
		<jsp:useBean id="newbean" class="javabean.User" scope="request" >
			<jsp:setProperty name="newbean" property="age" value="32" />
		<!-- ������ jsp:useBean ��ǣ����ڲ������ݶ����� -->
		</jsp:useBean>
	</body>
</html>
