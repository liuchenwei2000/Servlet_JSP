/**
 * 
 */
package servlet.demo;

/**
 * MVC֮Model
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-1-11
 */
public class CountryHelper {

	public String getArea(String country) {
		// ������Ĵ������ִ�з������ݿ�Ĳ�����
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
