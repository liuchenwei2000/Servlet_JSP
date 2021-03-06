## 动作指令简介 ##

JSP 规范中定义了一些标准的动作，用于为请求处理阶段提供信息，如操作 JavaBean、执行请求转发等，这些动作在请求处理阶段按照在页面中出现的顺序执行。

动作指令与编译指令不同，编译指令是通知 Servlet 引擎的处理消息，而动作指令只是运行时的动作。编译指令在将 JSP 编译成 Servlet 时起作用，而动作指令通常可替换为 JSP 脚本（scriptlet），它只是 JSP 脚本的标准化写法。

JSP 的 7个动作指令：

* `jsp:forward`：执行页面转向，将请求的处理转发到下一个页面。
* `jsp:param`：用于传递参数，必须与其他支持参数的标签一起使用。
* `jsp:include`：用于动态引入一个 JSP 页面。
* `jsp:plugin`：用于下载 JavaBean 或 Applet 到客户端执行。
	
	主要用于下载服务器端的 JavaBean 或 Applet 到客户端执行，由于程序在客户端执行，因此客户端必须安装JRE。
* `jsp:useBean`：创建一个 JavaBean 的实例。
* `jsp:setProperty`：设置 JavaBean 的属性值。
* `jsp:getProperty`：获取 JavaBean 的属性值。

这些动作指令并不能包办所有的功能，比如如果想在 JSP 中访问一个 bean 对象的属性，可以直接用 就是 `jsp:getProperty` 即可，但无法访问 bean 对象属性的属性。

比如 Person 对象有个 Address 类型的属性 address，address 又有自己的属性 String 类型的 street，只通过 JSP 动作是不能够访问 street 属性的。

要想解决这个问题，要么使用 scriptlet 直接用 Java 代码进行访问，要么使用 JSP 2.0 推荐的 表达式语言（EL）。EL 访问嵌套属性非常简单，详见 Servlet3_JSP2 项目。 
