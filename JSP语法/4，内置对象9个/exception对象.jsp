<%-- exception��java.lang.Throwable ��ʵ������ʵ����������ҳ���е��쳣�ʹ��� --%>
<%@ page contentType="text/html;charset=GBK" language="java" isErrorPage="true" %>
<%-- 
ֻ�е�ҳ���Ǵ�����ҳ�棬������ָ��page��isErrorPage����Ϊtrueʱ���ö���ſ�ʹ�á�
���⣬JSP������������Ȼ��Ҫ�Լ������쳣��JSP�쳣�������ֻ��_jspService()������Ĵ��������á�
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- ���÷����� getMessage() �ȡ� --%>
		<%= exception.getMessage() %>
	</body>
</html>

