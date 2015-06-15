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
		<br><br>
		<!-- fragment 标签 -->
		Fragment 标签：<br>
		<mt:border>
			<jsp:attribute name="content">
				<%-- 使用 jsp:attribute 动作为页面片段属性 content 传入参数值 <mt:helloworld/>  --%>
				<!-- 下面是动态的 JSP 页面片段 -->
				<mt:helloworld/>
			</jsp:attribute>
		</mt:border>
		<br><br>
		<!-- 动态属性 标签，使用时十分灵活，可以根据需要动态地传入任意多个属性。 -->
		动态属性 标签：<br>
		<mt:multi name="vicliu" age="27" email="liuchenwei@gmail.com" />
		<br><br>
</body>
</html>