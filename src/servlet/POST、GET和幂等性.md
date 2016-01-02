## POST、GET和幂等性 ##

幂等性说明多次重复做同一件事情而不会有预料不到的副作用（side-effect）。

HTTP GET 只是要得到东西，它不会修改服务器上的任何内容。所以，根据定义和HTTP 规范，GET 是幂等的。POST 不是幂等的，POST 体中的提交数据可能用于不可逆转的事务。POST 请求有一个体，GET请求没有，不过 GET 请求可以把请求参数追加到请求 URL 的后面（称为 查询串——query string）。

如果没有在表单（form）中指出 method="POST"，就会默认为 HTTP GET 请求。