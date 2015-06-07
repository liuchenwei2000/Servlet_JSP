<%-- 
page指令是针对当前页面的指令。通常位于JSP页面的顶端，一个JSP页面可以使用多条page指令。 

主要属性如下：

language：声明当前JSP页面使用的脚本语言的种类，通常是java，一般无需设置。
import：用来导入包，详见下面示例。如果不导入包，在脚本中使用时就必须是全限定类名。
session：设定JSP页面是否需要 HTTP Session。
info：设置该JSP页面的信息，可以通过 getServletInfo() 获取。

contentType：用于设定生成网页的文件格式和编码字符集，即MIME类型和页面字符集类型，浏览器会根据该属性指定的类型和编码显示网页内容。
			  默认的MIME类型是 text/html；默认的字符集类型是 ISO-8859-1。
pageEncoding：设置JSP页面的编码格式，在JSP页面中所有代码都使用该属性指定的字符集。一般需要将其设置成为支持中文的字符集，比如 UTF-8。

通常情况下，pageEncoding 和 contentType 属性会同时存在，
pageEncoding 的作用是指定JSP页面的编码格式，如果值设置为不支持中文的字符集（如ISO-8859-1），那么在这个页面中不能编写中文信息，否则会出现乱码。
contentType 的作用是指定服务器处理请求完成后，回应给浏览器的内容类型。如值设置为“text/html;charset=UTF-8”，则说明回应的页面是HTML文档或文本内容，其字符集为UTF-8。
--%>
<%@ page contentType="text/html;charset=GBK" language="java" pageEncoding="UTF-8" %>
<%-- 
errorPage属性 指定错误处理页面。
如果本页面产生了异常或者错误而又没有对应的异常处理代码，则会自动调用该属性所指定的JSP页面。
如果没有指定errorPage页面，系统会直接把异常信息呈献给客户端浏览器，这是要避免的。
--%>
<%@ page errorPage="error.jsp" %>
<%-- 
import属性 用来导入包，默认自动导入的包有：
java.lang.*、java.servlet.*、java.servlet.jsp.*、java.servlet.http.*。

多个包的话用逗号分隔 。
--%>
<%@ page import="java.util.*,java.sql.*" %><
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
	</body>
</html>

