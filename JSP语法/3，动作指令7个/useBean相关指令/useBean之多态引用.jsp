<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
<jsp:useBean> ���Խ�����̬�� bean ����
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
		���ֻ�� class ���ԣ��� class ���Լȱ�ʾ�������ͣ��ֱ�ʾʵ�����͡������������ɵ� servlet �����ǣ�
		
		 javabean.User bean1 = null;
		 // �� request ���ȡ bean1 ���ԵĴ���
		 if(bean1 == null) {
		 	bean1 = new javabean.User();
		 }
		-->
		<jsp:useBean id="bean1" class="javabean.User" scope="request" />
		
		<!--
		type ���Կ���ר������ָ���������ͣ���ʱ class ����ֻ��ʾʵ�����͡������������ɵ� servlet �����ǣ�
		
		 javabean.IUser bean2 = null;
		 // �� request ���ȡ bean2 ���ԵĴ���
		 if(bean2 == null) {
		 	bean2 = new javabean.User();
		 }
		 
		 type �����Ǿ������͡��������ͻ��߽ӿ����ͣ�ֻҪ������Ϊ bean ���� class ���͵������������ͣ�������ָ��Ϊ type��
		 ���ԣ���Ҳ��ζ�ţ�class ָ����������� type ��һ����������ʵ���ࡣ
		-->
		<jsp:useBean id="bean2" class="javabean.User" scope="request" />
	</body>
</html>

