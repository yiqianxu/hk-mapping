package com.hk.utils;

/**
 * 工具类
 * @author huangkai
 * @date 2015年8月13日 下午10:45:48
 * @version V1.0
 */
public class Utilities {

	private static final String IS = "is";
	private static final String GET = "get";
	private static final String SET = "set";
	private static final String BOOLEAN = "boolean";
	
	public static String set(String name) {
		return SET + capitalize(name);
	}

	public static String get(String type, String name) {
		String prefix = type.equalsIgnoreCase(BOOLEAN) ? IS : GET;
		return prefix + capitalize(name);
	}

	public static boolean isNull(Object obj) {
		return obj == null;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	public static String capitalize(String str) {
		char[] ch = str.toCharArray();
		ch[0] = Character.toUpperCase(ch[0]);
		return new String(ch);
	}

	public static String capitalize(String str, String separator) {
		return capitalize(str, separator, true);
	}

	public static String capitalize(String str, String separator, boolean initialUpperCase) {
		if (str.contains(separator)) {
			int index = 0;
			String target = "";
			String[] sources = str.split(separator);
			if (!initialUpperCase) {
				index = 1;
				target = sources[0].toLowerCase();
			}
			for (int i = index; i < sources.length; i++) {
				target += capitalize(sources[i]);
			}
			return target;
		} else {
			return initialUpperCase ? capitalize(str) : str.toLowerCase();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(capitalize("t_user","_"));
	}
	
}
