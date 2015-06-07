<%@ page contentType="text/html;charset=GBK" language="java" %>

<%-- 
导入tag文件中标签库的语法如下：
prefix与之前自定义标签taglib指令的prefix属性完全一样，用于确定标签前缀，
而tagdir标签库路径下存放了很多tag file，每个tag file对应一个标签。
--%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<% 
			java.util.List<String> list = new java.util.ArrayList<String>();
			list.add("A");
			list.add("B");
			list.add("C");
			request.setAttribute("bean", list);
		%>
		<p>
			<!-- 使用标签，格式如 tagPrefix:tagName... -->
			<tags: iterator list="bean" color="red" />
		</p>
	</body>
</html>

