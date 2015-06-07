<%-- 
include指令是动态包含指令，用于包含某个页面，被包含的页面可以是静态页面或动态页面。
它不会导入被include页面的编译指令，仅仅将被导入页面的body内容插入本页面。 
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
在JSP生成的servlet中，动态导入只是使用一个include方法来插入目标页面的内容，而不是将目标页面代码完全拷贝到本页面中。原理如下：

当浏览器第一次请求一个使用<jsp:include>包含其他页面的页面时，Web容器首先会编译被包含的页面，然后将编译处理后的返回结果包含在页面中，
之后再编译包含页面，最后将两个页面组合的结果响应给浏览器。（因为静态页面不需要编译即可被Web容器解析，所以它不会经历编译处理的过程。）

静态导入(inlcude编译指令)和动态导入(inlcude动作指令)的区别：
1，静态导入是将被导入页面的代码完全拷贝融入，两个页面融合成一个整体Servlet；而动态导入则在Servlet中使用include方法来引入被导入页面的内容。
2，静态导入时被导入页面的编译指令会起作用；而动态导入时被导入页面的编译指令则失去作用，只是插入被导入页面的body内容。
3，动态导入还可以增加额外的参数。
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP范例
		</title>
	</head>
	<body>
		<!-- 
		JSP的include指令的格式如下： 
		page 属性：指定被包含文件的相对路径。
		-->
		<jsp:include page="result.jsp">
			<!-- jsp:param 用于在增加额外的请求参数，参数值可以通过HttpServletRequest类的getParamter()方法获取。 -->
			<jsp:param name="age" value="22" />
		</jsp:include>
	</body>
</html>

