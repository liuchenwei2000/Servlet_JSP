
<%-- 
��JSP��֧��tag file�淶�£�tag file�����˱�ǩ�����࣬���ĸ�ʽ������JSP�ļ���

�Զ����ǩ�����ã�ͨ���򵥵ı�ǩ��ҳ��������һ������Ƭ�ϡ�ͬ��tag fileҲֻ��������һ��ҳ��Ƭ�Σ����Բ�����Ҫ���������HTMLҳ�档

Tag file�����������������¹���tagName.tag�����ļ������Ǳ�ǩ�����ļ�����׺������tag��
�����ļ��ŵ�WebӦ�õ�ĳ��·���£����·���൱�ڱ�ǩ���URI����

tag�ļ�����5������ָ�

taglib����JSP��taglibָ��Ч����ͬ�����ڵ���������ǩ�⡣
include����JSP��includeָ��Ч����ͬ�����ڵ�������JSP��HTMLҳ�档
tag����JSP��pageָ��Ч����ͬ����������ҳ���������ԡ�
attribute�����������Զ����ǩ�����ԣ��������Զ����ǩ�������еı�ǩ���ԡ�
variable�����������Զ����ǩ�ı�������Щ����������JSPҳ��ʹ�á�

���ö����У�
request��response��session��application��config��out��
--%>
<%@ tag pageEncoding="GBK" import="java.util.List" %>

<%@ attribute name="list" %>
<%@ attribute name="color" %>

<% 
	List<String> l = request.getAttribute(%>${list}<%);
	for(String value : l) {
%>
		</br><%=value %>
<%
	}
%>
