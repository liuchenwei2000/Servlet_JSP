<%-- config��javax.servlet.ServletConfig ��ʵ������ʵ�������JSP��������Ϣ�� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
��ʵ��JSPҳ��ͨ���������ã�Ҳ�Ͳ�����������Ϣ�����Ըö���������Servlet����Ч��
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- ���÷����� getInitParameter(String)��getInitParameters() �ȡ� --%>
		<%
		    // ��� web.xml �еĶ���
		    // ֻ��ͨ�� url/jspconfig ����ʱ���ܻ�ȡ��ʼ������ͨ��  url/config����.jsp ���޷����ʳ�ʼ�����ġ�
			String name = config.getInitParameter("name");
			String age = config.getInitParameter("age");
		%>
		<%-- ���е�JSPҳ�涼����ͬ��servlet name��jsp --%>
		<%=config.getServletName() %>>
	</body>
</html>

