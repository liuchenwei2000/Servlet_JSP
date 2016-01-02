## Filter 简介 ##

Filter 可认为是 Servlet 的一种增强版，主要用于对用户请求进行预处理，也可以对响应进行后处理，是个典型的处理链。

使用 Filter 完整的流程是：Filter 对用户请求进行预处理，然后将请求交给 Servlet 进行处理并生成响应，最后 Filter 再对服务器响应进行后处理。

Filter 的用处：

* 1，在 HttpServletRequest 到达 Servlet 之前进行拦截，根据需要检查 HttpServletRequest，也可以修改 HttpServletRequest 头和数据。
比如完成安全检查、重新格式化请求首部或体、建立请求审计或日志。

* 2，在 HttpServletResponse 到达客户端之前进行拦截，根据需要检查 HttpServletResponse，也可以修改 HttpServletResponse 头和数据。
比如压缩响应流、追加或修改响应流、创建一个完全不同的响应。

Filter 具体有如下几个种类：

* 1，用户授权 Filter：负责检查用户请求，根据请求过滤用户非法请求。
* 2，日志 Filter：详细记录某些特殊的用户请求。
* 3，负责解码的 Filter：对非标准编码的请求编码。
* 4，能改变 XML 内容的 XSLT Filter等。


Filter 可负责拦截多个请求或响应；一个请求或响应也可被多个 Filter 拦截。多个过滤器可以链到一起，一个接一个地运行。

过滤器设计为完全自包含的，过滤器并不关心在它前面运行了哪些过滤器，也不关心后面还会运行哪个过滤器。如果容器无法找到所请求的正确资源，则不会调用过滤器。

### Filter 实现网站伪静态 ###

对于以 JSP 为表现层开发的动态网站来说，用户访问的 URL 通常有如下形式：

xxx.jsp?param=value...

因为大部分搜索引擎都会优先考虑收录静态的 html 页面，而不是动态的 jsp、php 页面。但实际上绝大部分网站都是动态的，不可能全部是静态的 html 页面，因此互联网上的大部分网站都会使用伪静态——就是将 jsp、php 这种动态 URL 伪装成静态的 html 页面。

对于 JavaWeb 应用而言，可以通过 Filter 拦截所有发向 *.html 请求，然后按某种规则将请求 forward 到实际的JSP页面即可。

URL Rewriter 开源项目是一个可用的实现，使用详见 web.xml 中对 UrlRewriteFilter 的配置以及 urlrewirte.xml 文件。
