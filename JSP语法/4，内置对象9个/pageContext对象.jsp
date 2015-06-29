<%-- 
pageContext��javax.servlet.jsp.PageContext ��ʵ�����ö�������JSPҳ�������ġ� 
���������ĳЩ���������ṩ��һ�� pageContext ���ã���Щ��������Ϳ���ͨ�����õ�������ʽ����������Լ���������������ԡ�
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
ʹ�� pageContext ���Է���/���� page��request��session��application ��Χ�ı�����
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%
			// ȡ�� page ��Χ�ڵ� name ���� 
			String name = (String) pageContext.getAttribute("name");
			// ȡ�� request ��Χ�ڵ� age ���ԣ���������ֵ�� PAGE_SCOPE��SESSION_SCOPE��APPLICATION_SCOPE
			String age = (String) pageContext.getAttribute("age", PageContext.REQUEST_SCOPE);
			// ʹ�� pageContext����ʹ��֪��������Ҳ���Բ������ԣ���Χ˳���ǣ�pageContext��request��session��application
			pageContext.findAttribute("wow");
			
			// pageContext�������ڻ�ȡ�������ö������£�
			pageContext.getRequest();// ��ȡrequest����
			pageContext.getResponse();// ��ȡresponse����
			pageContext.getServletConfig();// ��ȡconfig����
			pageContext.getServletContext();// ��ȡapplication����
			pageContext.getSession();// ��ȡsession����
			
			// ͬ��������ͨ�� pageContext ���� setAttribute() ��ֵ����
		%>
	</body>
</html>

