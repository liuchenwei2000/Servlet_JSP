<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			���ʽ���ԡ������������
		</title>
	</head>
	<body>
		<table border="1" bgcolor="red">
			<tr>
				<td><b>���ʽ����</b></td>
				<td><b>������</b></td>
			</tr>
			<!-- ֱ��������� -->
			<tr>
				<td>\${1}</td>
				<td>${1}</td>
			</tr>
			<!-- �ӷ� -->
			<tr>
				<td>\${1 + 2}</td>
				<td>${1 + 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${1 - 2}</td>
				<td>${1 - 2}</td>
			</tr>
			<!-- �˷� -->
			<tr>
				<td>\${11 * 2}</td>
				<td>${11 * 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${11 / 2}</td>
				<td>${11 / 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${11 div 2}</td>
				<td>${11 div 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${11 % 2}</td>
				<td>${11 % 2}</td>
			</tr>
			<!-- ���� -->
			<tr>
				<td>\${11 mod 2}</td>
				<td>${11 mod 2}</td>
			</tr>
			<!-- ��Ԫ����� -->
			<tr>
				<td>\${(1 == 2) ? 3 : 4}</td>
				<td>${(1 == 2) ? 3 : 4}</td>
			</tr>
		</table>
	</body>
</html>

