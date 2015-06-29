<%@ page contentType="text/html;charset=GBK" language="java" %>
<%--  
输出表达式值的语法格式如下：
<%=表达式%>
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%! private int count = 0;  %>
		<%! 
			private int add(int a, int b){
			   return a + b;
			}
		%>
		<%-- 表达式后面不能有分号";"，因为表达式整体会成为 out.println() 的参数。 --%>
		<%=count++ %>
		<%=add(1, 2) %>
	</body>
</html>

