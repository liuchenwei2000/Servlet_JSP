<%@ page contentType="text/html;charset=GBK" language="java" %>

<!-- 
taglib ָ����������һ����ǩ�����ã���JSPҳ��֮���������ĸ���ǩ������ã�������JSPҳ���е����ĸ���ǩ��

taglib���﷨��ʽ���£�
prefix ���ԣ�ָ����ǩ��ǰ׺����JSPҳ��������ʹ�ø�ǰ׺�ı�ǩ���ɴ˱�ǩ�⴦�� 
uri ���ԣ�ȷ����ǩ���URI����tld�ļ��е�uri��Ӧ��
-->
<%@ taglib prefix="mytag" uri="http://taglib.mytag.com" %>
<!-- ���� JSTL ���ı�ǩ�� -->
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<% 
			java.util.List<String> list = new java.util.ArrayList<String>();
			list.add("A");
			list.add("B");
			list.add("C");
			// �� List ������� page ��Χ��
			pageContext.setAttribute("a", list);
		%>
		<p>
			<!-- ʹ�ñ�ǩ����ʽ�� tagPrefix:tagName... -->
			<mytag:helloworld />
			<!-- ʹ�ô����Եı�ǩ����Ϊ�������� -->
			<mytag:withAttribute cases="upper" />
			<!-- ʹ�ô���ǩ��ı�ǩ -->
			<mytag:iterator collection="a" item="item" >
				<tr>
					<td>${pageScope.item}</td>
				</tr>
			</mytag:iterator>
		</p>
	</body>
</html>

