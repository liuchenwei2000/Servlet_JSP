<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			表达式语言——内置对象
		</title>
	</head>
	<body>
        <!-- EL包含11个内置对象，如下： -->
        <p>
        	<!-- 代表该页面的pageContext对象，与JSP的pageContext内置对象相同 -->
        	${pageContext["attribute"]}
        	
        	<!-- 用于获取page范围内的属性值。 -->
        	${pageScope["attribute"]}
        	
        	<!-- 用于获取request范围内的属性值。 -->
        	${requestScope["attribute"]}
        	
        	<!-- 用于获取session范围内的属性值。 -->
        	${sessionScope["attribute"]}
        	
        	<!-- 用于获取application范围内的属性值。 -->
        	${applicationScope["attribute"]}
        	
        	<!-- 用于获取请求的参数值。 -->
        	${param["name"]}
        	
        	<!-- 与param的区别在于，该对象用于获取值为数组的属性。 -->
        	${paramValues["books"]}
        	
        	<!-- 用于获取请求头的属性值。 -->
        	${header["host"]}
        	
        	<!-- 与header的区别在于，该对象用于获取值为数组的属性。 -->
        	${headerValues["hosts"]}
        	
        	<!-- 用于获取Web应用的初始化参数。 -->
        	${initParam["user"]}
        	
        	<!-- 用于获取指定的Cookie值。 -->
        	${cookie["user"].value}
        </p>
	</body>
</html>

