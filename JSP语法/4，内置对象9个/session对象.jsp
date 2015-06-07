<%-- session：javax.servlet.http.HttpSession 的实例，代表一次用户会话。 --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@page import="java.util.*" %>
<%-- 
从客户端浏览器连接服务器开始，直到客户端浏览器与服务器断开为止，这个过程就是一次会话。

session常用于跟踪用户的会话信息，如判断用户是否登录系统，或者再购物车应用中，用于跟踪用户购买的商品等。
session范围内的属性可以在多个页面的跳转之间共享，一旦关闭浏览器，session结束，其范围内的属性将全部丢失。

session机制通常用于保存客户端的状态信息，这些信息需要保存到Web服务器的硬盘上，所以要求session里的属性值必须是可序列化的。
--%>
<%-- 模仿购物车 --%>
		<%
			// 取出 session 中的购物车
			Map<String, Integer> trolley = (Map<String, Integer>) session.getAttribute("trolley");
			if (trolley == null) {// 初始化购物车
				trolley = new HashMap<String, Integer>();
				trolley.put("bike", 0);
				trolley.put("computer", 0);
				trolley.put("book", 0);
			}

			String[] items = request.getParameterValues("items");
			for (String item : items) {
				Integer number = trolley.get(item);
				if (number == null) {
					trolley.put(item, 1);
				} else {
					trolley.put(item, ++number);
				}
			}

			// 将购物车放置到 session 范围
			session.setAttribute("trolley", trolley);
		%>
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

