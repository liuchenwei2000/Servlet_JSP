<%-- application��javax.servlet.ServletContext��ʵ������ʵ������JSP������WebӦ�ñ��� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
�ö���ͨ����������;��

1��������WebӦ�õĶ��JSP��Servlet֮�乲�����ݡ�
һ�������ݷ���application�У����Ϳ��Ա���Ӧ���µ�����JSP��Servlet���ʡ�

2������WebӦ�õ����ò�����
ͨ�����ַ�ʽ�����Խ�һЩ������Ϣ����web.xml�ļ��У�����ʹ��Ӳ���뷽ʽд�ڴ�����Ӷ���߿���ֲ�ԡ�
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- ���÷����� getAttribute(String)��setAttribute(String,String)��getInitParameter(String)�ȡ� --%>
		<%
			// ��� web.xml �еĶ���
			String url = application.getInitParameter("url");
			String pw = application.getInitParameter("password");
			
			application.setAttribute("name", "John");
			
			String name = (String) application.getAttribute("name");
		%>
	</body>
</html>

