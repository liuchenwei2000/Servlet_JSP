<%@ page contentType="text/html;charset=GBK" language="java" %>
<%-- 
JSP�����������������ͷ��������ǻᱻת���ɶ�ӦServlet��ĳ�Ա�����ͳ�Ա���������JSP������Ҫ����Java�﷨��

JSP�������﷨��ʽ���£�
<%! �������� %>
--%>
<!DOCTYPE html>
<html>
	<head>
		<title>
			JSP����
		</title>
	</head>
	<body>
		<%! private int count = 0;  %>
		<%! 
			// ������ static ����
			public static void print(String s){
			    System.out.println(s);
			}
		
			public int getCount(){
		    	return count;
			}
		%>
	</body>
</html>

