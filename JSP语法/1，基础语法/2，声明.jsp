<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
JSP声明用于声明变量和方法，它们会被转换成对应Servlet类的成员变量和成员方法，因此JSP声明需要符合Java语法。

JSP声明的语法格式如下：
<%! 声明部分 %>
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
			public void print(String s){
			    System.out.println(s);
			}
		%>
	</body>
</html>

