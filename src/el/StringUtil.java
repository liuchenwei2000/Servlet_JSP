/**
 * 
 */
package el;

/**
 * EL函数处理类
 * <p>
 * 这个类中包含若干静态方法，每个静态方法都可定义成一个函数，也完全可以直接使用JDK自带的类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年10月13日
 */
public class StringUtil {

	public static String toUpper(String arg){
		return arg.toUpperCase();
	}
	
	public static String toLower(String arg){
		return arg.toLowerCase();
	}
}
