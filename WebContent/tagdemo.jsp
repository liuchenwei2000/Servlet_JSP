<%@page contentType="text/html; charset=GBK" %>
<%@page import="java.util.*" %>
<!-- 导入标签库，将标签库和指定前缀关联起来 -->
<%@ taglib uri="http://taglib.mytag.com" prefix="mt" %>
<!DOCTYPE html>
<html>
<head>
<title>Tag demo</title>
</head>
<body>
		<!-- 使用自定义标签 -->
		简单标签：<br><mt:helloworld />
		<br><br>
		带属性的标签<br><mt:withAttribute cases="upper" />
		<br><br>
		<%
		List<String> names = new ArrayList<String>();
		names.add("Tom");
		names.add("Ann");
		names.add("Peter");
		
		pageContext.setAttribute("list", names);
		%>
		带标签体的标签<br>
		<mt:iterator collection="list" item="item" >
				${pageScope.item}
			<br>		
		</mt:iterator>
</body>
</html>