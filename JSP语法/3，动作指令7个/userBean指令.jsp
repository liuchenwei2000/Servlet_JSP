<%-- useBean��setProperty��getProperty������ָ�����JavaBean��صġ� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
useBeanָ��������JSPҳ���г�ʼ��һ��Javaʵ����
setPropertyָ������ΪJavaBeanʵ����������ֵ��
getPropertyָ�����ڻ�ȡJavaBeanʵ�������ԡ�
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<!-- 
		JSP��useBeanָ��ĸ�ʽ���£� 
		����id������JavaBean��ʵ������class����ָ��JavaBean��ʵ���࣬scope��������ָ��JavaBeanʵ�������÷�Χ���÷�Χ������4��ֵ��
		page����ҳ����Ч��
		request������������Ч��
		session������session��Ч��
		application����Ӧ����Ч��
		-->
		<jsp:useBean id="mybean" class="login.User" scope="page" />
		
		<!-- 
		JSP��setPropertyָ��ĸ�ʽ���£�
		����name����ָ��JavaBean��ʵ������property����ָ�������õ���������value����ָ�������õ�����ֵ��
		-->
		<jsp:setProperty name="mybean" property="age" value="32" />
		
		<!-- JSP��getPropertyָ��ĸ�ʽ���£� -->
		<jsp:getProperty name="mybean" property="age" />
	</body>
</html>

