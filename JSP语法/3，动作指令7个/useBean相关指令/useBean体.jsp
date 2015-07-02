<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
<jsp:useBean> 可以有体。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
	
		<%--
		如果把设置方法代码（<jsp:setProperty>）放在 <jsp:useBean> 的体中，这样就能有条件地设置 property 值了。
		只有在指定范围（本例是 request）内找不到 bean 而且创建一个新 bean 时才会运行体里面的代码。
		--%>
		<jsp:useBean id="newbean" class="javabean.User" scope="request" >
			<jsp:setProperty name="newbean" property="age" value="32" />
		<!-- 最后结束 jsp:useBean 标记，其内部的内容都是体 -->
		</jsp:useBean>
	</body>
</html>
