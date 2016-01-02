## Servlet规范、JSP规范 ##

### Web 概念 ###

Web 服务器接收客户请求，然后向客户返回一些结果。Web 浏览器允许用户请求服务器上的某个资源，并且向用户显示请求的结果。

**HTTP** 是 Web 上客户和服务器之间进行通信所用的协议，HTML 告诉浏览器怎样把内容呈现给用户。

HTTP 会话的结构是一个简单的请求/响应序列，浏览器发出请求，服务器做出响应。HTML 是 HTTP 响应的一部分，可以把 HTML 内容看作是粘贴到 HTTP 响应中的数据。

浏览器发现一个图片标记 `<img>` 时，会生成另一个 HTTP 请求，得到标记所描述的资源。

HTTP 响应包括一个首部和一个体。首部信息告诉浏览器使用了什么协议，请求是否成功，以及体中包括何种类型的内容。体包含了让浏览器显示的具体内容，如 HTML。比如 `content-type` 响应首部的值称为 MIME 类型，它告诉浏览器要接收的数据是什么类型，这样浏览器才能知道如何显示这些数据。MIME 类型值与 HTTP 请求 "Accept" 首部中所列的值相关。

**端口** 表示与服务器硬件上运行的一个特定软件的逻辑连接，并不表示一个可以插入物理设备的位置。它们只是表示服务器应用的逻辑数而已。如果没有端口号，服务器就没有办法知道客户想连接哪个应用。

### Web 容器的主要功能 ###

* 1，通信支持

	如 socket 通信、监听端口、创建流等。

* 2，生命周期管理

	容器控制 servlet 的生与死。

* 3，多线程支持

	容器会自动地为它接收的每个 servlet 请求创建一个新的线程，针对客户的请求，如果 servlet 已经运行完相应的服务方法，这个线程就会被结束（死掉）。

* 4，声明方式实现安全
	
	通过 XML 部署描述文件配置安全性，而不必硬编码到 servlet 类代码中，避免了重新编译，增强了灵活性。

* 5，JSP支持

Web 容器用于 Web 组件（Servlet 和 JSP），EJB 容器用于业务组件。一个完全兼容的 JavaEE 应用服务器必须有一个 Web 容器和一个 EJB 容器（以及其他一些部件，包括 JNDI 和 JMS 实现）。

比如 Apache/Nginx 是HTTP Web服务器，Tomcat 是 Web 容器，WebLogic 是 JavaEE 服务器。




Servlet优势

在服务器上仅有一个Java虚拟机在运行，其优势在于当多个来自客户端的请求访问时，Servlet为每个请求分配一个线程，而不是进程。


部署步骤

1，将servlet源文件编译成class文件或导出成*.war文件。
2，将class文件或war包放在WEB-INF/classes路径下，如果servlet有包名，还应该将class文件放在对应的包路径下。
3，在web.xml中配置servlet。

### Servlet 概念 ###

#### 生命周期 ####

servlet 在容器中运行时，其实例的创建及销毁都不是由程序员决定的，而是由 Web 容器进行控制的。servlet 从“不存在”状态迁移到“初始化”状态（这意味着已经准备好为客户请求提供服务），首先是从构造函数开始，但是构造函数只是使之成为一个对象，而不是一个 servlet。要想成为一个 servlet，对象必须具备一些 servlet 特性。

当容器为 servlet 建立一个 `ServletConfig` 并调用其 `init()` 方法后，对象将成为一个 servlet，它会得到 servlet 该有的所有特权，比如能够使用 `ServletContext` 引用从容器得到信息。

每个 servlet 的运行都遵循如下生命周期：

* 1，创建servlet实例。

	有两个时机：
	当客户端第一次请求某个servlet时，系统创建其实例，大部分的servlet都是这样。
	Web应用启动时立即创建servlet实例，即 load-on-startup servlet。

* 2，Web容器调用servlet的init方法，对servlet进行初始化。

* 3，servlet初始化后，将一直存在于容器中，用于响应客户端请求。

* 4，Web容器决定销毁servlet时，先调用其destroy方法，通常在关闭Web应用之时销毁servlet。


#### ServletConfig 对象 ####

每个 Servlet 都有一个 ServletConfig 对象，用于向 servlet 传递部署时信息（例如数据库信息），而你不想把这个信息硬编码写到 servlet 中（servlet初始化参数），用于访问 ServletContext。


#### ServletContext 对象 ####

每个 Web 应用有一个 ServletContext，用于访问 Web 应用参数（在部署描述文件中配置），用于得到服务器信息，包括容器名和容器版本，以及所支持API的版本等。
