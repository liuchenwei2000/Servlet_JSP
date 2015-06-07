
<%-- 
在JSP所支持tag file规范下，tag file代理了标签处理类，它的格式类似于JSP文件。

自定义标签的作用：通过简单的标签在页面上生成一个内容片断。同理，tag file也只负责生成一个页面片段，所以并不需要输出完整的HTML页面。

Tag file的命名必须遵守如下规则：tagName.tag，即文件名就是标签名，文件名后缀必须是tag。
将该文件放到Web应用的某个路径下，这个路径相当于标签库的URI名。

tag文件具有5个编译指令：

taglib：与JSP的taglib指令效果相同，用于导入其他标签库。
include：与JSP的include指令效果相同，用于导入其他JSP或HTML页面。
tag：与JSP的page指令效果相同，用于设置页面编码等属性。
attribute：用于设置自定义标签的属性，类似于自定义标签处理类中的标签属性。
variable：用于设置自定义标签的变量，这些变量将传给JSP页面使用。

内置对象有：
request、response、session、application、config、out。
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
