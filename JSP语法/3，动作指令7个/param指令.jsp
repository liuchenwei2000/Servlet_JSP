<%-- paramָ���������ò���ֵ�����ָ����ܵ���ʹ�ã�������include��forwardָ�����ʹ�á� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- ����includeָ����ʹ��ʱ��paramָ�����ڽ��������뱻�����ҳ�档 --%>
	    <jsp:include page="result.jsp">
			<jsp:param name="age" value="22" />
		</jsp:include>
		<%-- ����forwardָ����ʹ��ʱ��paramָ�����ڽ�����ֵ���뱻ת���ҳ�档 --%>
		<jsp:forward page="result.jsp">
			<jsp:param name="age" value="22" />
		</jsp:forward>
	</body>
</html>

