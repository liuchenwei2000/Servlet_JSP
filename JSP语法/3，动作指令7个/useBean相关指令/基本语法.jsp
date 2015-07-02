<%-- useBean��setProperty��getProperty������ָ�����JavaBean��صġ� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
useBean ָ��������JSPҳ���������ͳ�ʼ��һ�� bean ���ԣ�
setProperty ָ������ΪJavaBeanʵ����������ֵ��
getProperty ָ�����ڻ�ȡJavaBeanʵ�������ԡ�
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
		���� id ������ JavaBean ��ʵ������class ����ָ�� JavaBean ����ȫ�޶�������scope ��������ָ�� JavaBean ʵ�������÷�Χ���÷�Χ������4��ֵ��
		page����ҳ����Ч����Ĭ��������
		request������������Ч��
		session������session��Ч��
		application����Ӧ����Ч��
		-->
		<!-- 
		����� ָ�������򣨱����� page����Χ���Ҳ���һ����Ϊ "mybean" �����Զ��������ͻᴴ��һ����ʵ����
		Ȼ������ʵ������ id ������ͬʱ��������Ϊָ�������򣨱����� page���е�һ�����ԡ� 
		-->
		<jsp:useBean id="mybean" class="javabean.User" scope="page" />
		
		<!-- 
		JSP��setPropertyָ��ĸ�ʽ���£�
		���� name ����ָ�� JavaBean ��ʵ������������ jsp:useBean �� id ֵƥ�䣩��property ����ָ�������õ���������value ����ָ�������õ�����ֵ��
		-->
		<jsp:setProperty name="mybean" property="age" value="32" />
		
		<!-- JSP��getPropertyָ��ĸ�ʽ���£� -->
		<jsp:getProperty name="mybean" property="age" />
	</body>
</html>

