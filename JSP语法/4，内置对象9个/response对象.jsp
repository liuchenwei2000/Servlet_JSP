<%-- 
response��javax.servlet.http.HttpServletResponse ��ʵ��������������Կͻ��˵���Ӧ�� 
ͨ�������ض�����ҳ������HTTP��Ӧ��ͷ�ͻ��������õȡ�
--%>
<%-- ͨ�� contentType ����ָ����Ӧ������ͼƬ --%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.awt.image.*" %>
<%@page contentType="text/html" language="java" pageEncoding="GBK" %>
<%-- 
ͨ������ʹ�øö���ֱ����Ӧ������ʹ��out���󣬳�����Ҫ���ɷ��ַ���Ӧ����out��JspWriter��ʵ�������ַ������޷�������ַ����ݡ�
������Ҫ��JSPҳ���ж�̬����һ��ͼ�������һ��PDF�ĵ���ʹ��out��Ϊ��Ӧ�����޷���ɣ�����ʹ��response��Ϊ��Ӧ�����
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%-- 1��response ���ɷ��ַ���Ӧ�� --%>
		<%
			// ����ҳ������ָ���ĸ�ʽ�����������У�������ʽ�� text/html��text/plain��application/msword
		 	response.setContentType("image/png");
			BufferedImage image = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
		    // ʹ�� image ���л�ͼ
		    javax.imageio.ImageIO.write(image, "png", response.getOutputStream());
		%>
		<!-- ʹ��������ʱ����ͼƬ�ķ�ʽ������ʵ����ҳ�ϵ�ͼ����֤�빦�ܡ� -->
		<img alt="��֤��" src="img.jsp">
		
		<%-- 2���ض��� --%>
		<%
			// ��forward��ͬ���ǣ�redirect���ض��򣩻ᶪʧ���е����������request��Χ�����ԡ�
			// ��Ϊ�ض������ɵڶ���������ǰһ��������ͬһ��request��Χ�ڣ����Է��͵�һ������������������request��Χ������ȫ����ʧ��
			response.sendRedirect("result.jsp");
		%>
		
		<%-- 
		3������Cookie��
		Cookieͨ��������վ��¼�û���ĳЩ��Ϣ�������û����ȡ�һ���û��´ε�¼����վ���Ի�ȡ�û��������Ϣ��������Щ��Ϣ�����ṩ���Ѻõķ���
		Cookie��session�Ĳ�֮ͬ�����ڣ�session����������Ĺرն�ʧЧ����Cookie��һֱ����ڿͻ��˻����ϣ����ǳ���Cookie���������ޡ�
		Cookie ֵ��������������ַ������ȷʵ��Ҫ�Ļ�������ʹ�� java.net.URLEncoder �������ַ����б�������ΪCookieֵ����ȡ��ʱ��ʹ��
		java.net.URLDecoder ���н�����ʹ�á�
		--%>
		<%
			String name = request.getParameter("username");
			Cookie cookie = new Cookie("username", name);
			cookie.setMaxAge(24 * 60 * 60);// Cookie������������24Сʱ
			response.addCookie(cookie);// ��ͻ�������Cookie
		%>
		<!-- ���ʿͻ��� Cookie ʹ��request���� -->
		<%
			// ��ȡ��վ�ڿͻ��˱���������Cookie
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				// �ҵ�����Ȥ�� Cookie
				if(c.getName().equals("username")){
					out.println(c.getValue());
				}
			}
		%>
		
		<%-- 4������HTTPͷ��Ϣ�� --%>
		<%
			/**
			���û���
			
			Ĭ������£�������Ỻ����ʾ����ҳ���ݡ��������û��ٴη�����ͬ����ҳʱ����������ж���ҳ�Ƿ��б仯��
			���û�б仯����ֱ����ʾ�����е����ݣ��������������ҳ����ʾ�ٶȡ�����һЩ��ȫ��Ҫ��ϸߵ���վ��ͨ����Ҫ���û��档
			*/ 
			response.setHeader("Cache-Control", "no-store");
			response.setDateHeader("Expires", 0);
		
			
			/**
			ҳ���Զ�ˢ��
			*/ 
			response.setHeader("refresh", "10");// ÿ��10���Զ�ˢ��һ��
			
			/**
			��ʱ��ת��ҳ
			*/ 
			response.setHeader("refresh", "5;URL=login.jsp");// ÿ��ʮ5���Զ���ת��ָ��ҳ��
		%>
	</body>
</html>

