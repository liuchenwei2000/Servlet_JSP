<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			表达式语言——算数运算符
		</title>
	</head>
	<body>
		<table border="1" bgcolor="red">
			<tr>
				<td><b>表达式语言</b></td>
				<td><b>运算结果</b></td>
			</tr>
			<!-- 直接输出常量 -->
			<tr>
				<td>\${1}</td>
				<td>${1}</td>
			</tr>
			<!-- 加法 -->
			<tr>
				<td>\${1 + 2}</td>
				<td>${1 + 2}</td>
			</tr>
			<!-- 减法 -->
			<tr>
				<td>\${1 - 2}</td>
				<td>${1 - 2}</td>
			</tr>
			<!-- 乘法 -->
			<tr>
				<td>\${11 * 2}</td>
				<td>${11 * 2}</td>
			</tr>
			<!-- 除法 -->
			<tr>
				<td>\${11 / 2}</td>
				<td>${11 / 2}</td>
			</tr>
			<!-- 除法 -->
			<tr>
				<td>\${11 div 2}</td>
				<td>${11 div 2}</td>
			</tr>
			<!-- 求余 -->
			<tr>
				<td>\${11 % 2}</td>
				<td>${11 % 2}</td>
			</tr>
			<!-- 求余 -->
			<tr>
				<td>\${11 mod 2}</td>
				<td>${11 mod 2}</td>
			</tr>
			<!-- 三元运算符 -->
			<tr>
				<td>\${(1 == 2) ? 3 : 4}</td>
				<td>${(1 == 2) ? 3 : 4}</td>
			</tr>
		</table>
	</body>
</html>

