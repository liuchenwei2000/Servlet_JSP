<%-- 
session��javax.servlet.http.HttpSession ��ʵ��������һ���û��Ự�� 
��������ͬһ��Ӧ�ó�����ÿ���ͻ��˵ĸ���ҳ���й������ݣ�ͨ�����ڱ����û���Ϣ�͹��ﳵ��Ϣ�ȡ�
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@page import="java.util.*" %>
<%-- 
session������ͬһ������У��ڸ���ҳ���й������ݡ����۵�ǰ������Ƿ��ڶ��ҳ���ִ������ת�����������û��Ựһֱ���ڣ�ֱ���ر��������
�����һ���Ự�пͻ��˳�ʱ�䲻�������������session����ͻ��Զ���ʧ�����ʱ��ȡ���ڷ��������ã�����TomcatĬ����30���ӡ�

session�����ڸ����û��ĻỰ��Ϣ�����ж��û��Ƿ��¼ϵͳ�������ٹ��ﳵӦ���У����ڸ����û��������Ʒ�ȡ�
session��Χ�ڵ����Կ����ڶ��ҳ�����ת֮�乲��һ���ر��������session�������䷶Χ�ڵ����Խ�ȫ����ʧ��

session����ͨ�����ڱ���ͻ��˵�״̬��Ϣ����Щ��Ϣ��Ҫ���浽Web��������Ӳ���ϣ�����Ҫ��session�������ֵ�����ǿ����л��ġ�
--%>
		<%-- ģ�¹��ﳵ --%>
		<%
			// ȡ�� session �еĹ��ﳵ
			Map<String, Integer> trolley = (Map<String, Integer>) session.getAttribute("trolley");
			if (trolley == null) {// ��ʼ�����ﳵ
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

			// �����ﳵ���õ� session ��Χ
			session.setAttribute("trolley", trolley);
		%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<!-- session ����ĳ���API -->
		<%
			// ����session�����Чʱ�䣬��λΪ��
			session.setMaxInactiveInterval(60*60);
			// ���ؿͻ������һ����Ự�����������ʱ��
			session.getLastAccessedTime();
		%>
	</body>
</html>

