<%@ page contentType="text/html;charset=GBK" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			���ʽ���ԡ������ö���
		</title>
	</head>
	<body>
        <!-- EL����11�����ö������£� -->
        <p>
        	<!-- �����ҳ���pageContext������JSP��pageContext���ö�����ͬ -->
        	${pageContext["attribute"]}
        	
        	<!-- ���ڻ�ȡpage��Χ�ڵ�����ֵ�� -->
        	${pageScope["attribute"]}
        	
        	<!-- ���ڻ�ȡrequest��Χ�ڵ�����ֵ�� -->
        	${requestScope["attribute"]}
        	
        	<!-- ���ڻ�ȡsession��Χ�ڵ�����ֵ�� -->
        	${sessionScope["attribute"]}
        	
        	<!-- ���ڻ�ȡapplication��Χ�ڵ�����ֵ�� -->
        	${applicationScope["attribute"]}
        	
        	<!-- ���ڻ�ȡ����Ĳ���ֵ�� -->
        	${param["name"]}
        	
        	<!-- ��param���������ڣ��ö������ڻ�ȡֵΪ��������ԡ� -->
        	${paramValues["books"]}
        	
        	<!-- ���ڻ�ȡ����ͷ������ֵ�� -->
        	${header["host"]}
        	
        	<!-- ��header���������ڣ��ö������ڻ�ȡֵΪ��������ԡ� -->
        	${headerValues["hosts"]}
        	
        	<!-- ���ڻ�ȡWebӦ�õĳ�ʼ�������� -->
        	${initParam["user"]}
        	
        	<!-- ���ڻ�ȡָ����Cookieֵ�� -->
        	${cookie["user"].value}
        </p>
	</body>
</html>

