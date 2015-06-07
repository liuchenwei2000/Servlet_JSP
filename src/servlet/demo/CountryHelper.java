/**
 * 
 */
package servlet.demo;

/**
 * MVC之Model
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-1-11
 */
public class CountryHelper {

	public String getArea(String country) {
		// 这里面的代码可以执行访问数据库的操作等
		if ("USA".equalsIgnoreCase(country)) {
			return "9,129,091 km2";
		} else if ("china".equalsIgnoreCase(country)) {
			return "960w km2";
		} else if ("Russia".equalsIgnoreCase(country)) {
			return "17,075,400 km2";
		}
		return "Unknown";
	}
}
