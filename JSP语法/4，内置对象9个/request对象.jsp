<%-- request��javax.servlet.http.HttpServletRequest ��ʵ�����ö����װ��һ�����󣬿ͻ����������������װ�ڸö������ȡ�ͻ��������������ʹ�øö��� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- 1����ȡ����ͷ/��������� --%>
		<%
			// ��ȡ��������ͷ������
			java.util.Enumeration<String> headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String headerName = (String) headerNames.nextElement();
				// ��ȡ��������ͷ
				System.out.println(request.getHeader(headerName));
			}
			// ���ý��뷽ʽ�����ڼ�������ʹ�� GBK
			request.setCharacterEncoding("GBK");
			// ��ȡ���������ֵ
			String name = request.getParameter("name");
			// ��ȡ�������������ֵ����������ж��ֵ��
			String[] list = request.getParameterValues("list");
		%>
		
		<%-- 2������request��Χ���ԡ� --%>
		<%
			request.setAttribute("name", "John");
			// ��ȡ���������ֵ
			String name2 = (String) request.getAttribute("name");
		%>
		
		<%-- 3��ִ��forward��include��Ҳ���Ǵ���JSP���ṩ��forward��include������� --%>
		<%
			// path�ַ��������� б�� ��ͷ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
		    dispatcher.forward(request, response);// ִ�� forward
		    dispatcher.include(request, response);// ִ�� include
		%>
	</body>
</html>

