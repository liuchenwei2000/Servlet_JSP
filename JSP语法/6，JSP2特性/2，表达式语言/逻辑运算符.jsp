<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			���ʽ���ԡ����߼������
		</title>
	</head>
	<body>
		<table border="1" bgcolor="red">
			<tr>
				<td><b>���ʽ����</b></td>
				<td><b>������</b></td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${1 &gt; 2}</td>
				<td>${1 > 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${1 > 2}</td>
				<td>${1 gt 2}</td>
			</tr>
			<!-- С�� -->
			<tr>
				<td>\${1 &lt; 2}</td>
				<td>${1 < 2}</td>
			</tr>
			<!-- С�� -->
			<tr>
				<td>\${1 < 2}</td>
				<td>${1 lt 2}</td>
			</tr>
			<!-- ���ڵ��� -->
			<tr>
				<td>\${1 &ge; 2}</td>
				<td>${1 >= 2}</td>
			</tr>
			<!-- ���ڵ��� -->
			<tr>
				<td>\${1 >= 2}</td>
				<td>${1 ge 2}</td>
			</tr>
			<!-- С�ڵ��� -->
			<tr>
				<td>\${1 &le; 2}</td>
				<td>${1 <= 2}</td>
			</tr>
			<!-- С�ڵ��� -->
			<tr>
				<td>\${1 <= 2}</td>
				<td>${1 le 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${1 == 2}</td>
				<td>${1 == 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${1 eq 2}</td>
				<td>${1 eq 2}</td>
			</tr>
			<!-- ������ -->
			<tr>
				<td>\${1 != 2}</td>
				<td>${1 != 2}</td>
			</tr>
			<!-- ������ -->
			<tr>
				<td>\${1 ne 2}</td>
				<td>${1 ne 2}</td>
			</tr>
		</table>
	</body>
</html>

