<%-- forward ָ�����ڽ�������Ĵ���ת���������ҳ�棬�ȿ����Ǿ�̬��htmlҳ�棬Ҳ�����Ƕ�̬��jspҳ�棬����ת���������е�servlet�� --%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
ִ��forwardָ��ת������ʱ���û�����ĵ�ַ��Ȼû�з����ı䣬��ҳ������ȴ��ȫ��Ϊת�����Ŀ��ҳ��
ͬʱ�ͻ��˵�����������ᶪʧ����ʵ����û����������ҳ�淢������ֻ����ȫ��������ҳ�������û�������Ӧ��

��Ҫע����ǣ�����ת��ʱ������ת������Ŀ����Դ���Ȼ������Ӧ����������ת��ǰд����Ӧ���������ݶ��ᱻ�������
���⣬Ҳ��Ҫ��ˢ�������ת���������� IllegalStateException��
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<!-- JSP��forwardָ��ĸ�ʽ���£� -->
		<jsp:forward page="result.jsp">
			<!-- jsp:param ���������Ӷ�����������������ֵ����ͨ��HttpServletRequest���getParamter()������ȡ�� -->
			<jsp:param name="age" value="22" />
		</jsp:forward>
	</body>
</html>

