<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
������ʽֵ���﷨��ʽ���£�
<%=���ʽ%>
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%! private int count = 0;  %>
		<%! 
			private int add(int a, int b){
			   return a + b;
			}
		%>
		<%-- ���ʽ���治���зֺ�";"����Ϊ���ʽ������Ϊ out.println() �Ĳ����� --%>
		<%=count++ %>
		<%=add(1, 2) %>
	</body>
</html>

