<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
<jsp:useBean> 可以建立多态的 bean 引用
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
		如果只有 class 属性，那 class 属性既表示引用类型，又表示实际类型。下面的语句生成的 servlet 代码是：
		
		 javabean.User bean1 = null;
		 // 从 request 域获取 bean1 属性的代码
		 if(bean1 == null) {
		 	bean1 = new javabean.User();
		 }
		-->
		<jsp:useBean id="bean1" class="javabean.User" scope="request" />
		
		<!--
		type 属性可以专门用来指定引用类型，此时 class 属性只表示实际类型。下面的语句生成的 servlet 代码是：
		
		 javabean.IUser bean2 = null;
		 // 从 request 域获取 bean2 属性的代码
		 if(bean2 == null) {
		 	bean2 = new javabean.User();
		 }
		 
		 type 可以是具体类型、抽象类型或者接口类型，只要能用作为 bean 对象 class 类型的声明引用类型，都可以指定为 type。
		 所以，这也意味着，class 指定的类必须是 type 的一个子类或具体实现类。
		-->
		<jsp:useBean id="bean2" class="javabean.User" scope="request" />
	</body>
</html>

