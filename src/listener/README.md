## Listener 简介 ##

Servlet API 提供了大量监听器来监听 Web 应用的内部事件，从而允许当 Web 内部事件（如 Web 应用被启动、Web 应用被停止、用户 session 开始、用户 session 结束、用户请求到达）发生时回调事件监听器内的方法。

使用 Listener 只需要两个步骤：

* 1，定义 Listener 实现类。
* 2，部署 Listener（web.xml中配置）。