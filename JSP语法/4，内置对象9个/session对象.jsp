<%-- session��javax.servlet.http.HttpSession ��ʵ��������һ���û��Ự�� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@page import="java.util.*" %>
<%-- 
�ӿͻ�����������ӷ�������ʼ��ֱ���ͻ����������������Ͽ�Ϊֹ��������̾���һ�λỰ��

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
		
	</body>
</html>

