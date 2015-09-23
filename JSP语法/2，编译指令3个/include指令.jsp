<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
        <%-- 
        include 指令可以将一个外部文件嵌入到当前JSP文件中。
        include 指令是静态包含，它会复制所包含文件中的所有内容，再把它粘贴到这个文件中，而且就放在这里，
		即使被包含文件中有JSP代码，在复制时也不会被编译执行。原理如下：
		
		当浏览器第一次请求一个使用 <%@ include %> 指令包含其他页面的JSP时，Web容器首先会合并两个JSP文件的源代码，并创建/转换Java源文件。
		然后将Java源文件编译成class文件，成为servlet类，前面的步骤只发生一次，此后发生的事情就跟普通的 servlet 一样了。
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

