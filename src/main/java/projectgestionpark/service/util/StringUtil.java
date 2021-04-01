package projectgestionpark.service.util;

public class StringUtil {
	
	public static boolean isEmpty(String value) {
		return (value==null || value.isEmpty());
		
	}
	public static boolean isnotEmpty(String value) {
	return !isEmpty(value);
}
}