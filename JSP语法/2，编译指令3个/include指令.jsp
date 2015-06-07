<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
        <%-- 
        include 指令可以将一个外部文件嵌入到当前JSP文件中。 
        include 指令是静态包含，即被包含文件中所有内容会被全部复制到该JSP页面中，即使被包含文件中有JSP代码，在复制时也不会被编译执行。
		将两个页面组合成一个页面后编译处理，最后返回单个结果页面。
        --%>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<%@ include file="header.html" %>
		<p>这是正文</p>
		<%@ include file="footer.jsp" %>
	</body>
</html>

