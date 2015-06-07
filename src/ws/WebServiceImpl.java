/**
 * 
 */
package ws;

import javax.jws.WebService;

/**
 * webservice的实现类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年5月21日
 */
@WebService(endpointInterface="ws.IWebService")
public class WebServiceImpl implements IWebService {

	@Override
	public String sayHello() {
		System.out.println("response");
		return "Hello world";
	}
}
