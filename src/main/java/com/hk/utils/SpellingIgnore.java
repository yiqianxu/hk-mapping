package com.hk.utils;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author huangkai
 * @version V1.0
 */
public class SpellingIgnore {

	public static List<String> ignoreTables() {
		String [] tables = ignore(PropertiesUtils.get("ignore.tahles"));
		return tables == null ? null : Arrays.asList(tables);
	}
	
	public static List<String> ignoreColumns(){
		String [] columns = ignore(PropertiesUtils.get("ignore.columns"));
		return columns == null ? null : Arrays.asList(columns);
	}

	private static String[] ignore(String items) {
		if(items == null || items.length() == 0) {
			return null;
		}
		String[] array = items.split(",");
		int i = 0 ;
		for (String arr : array) {
			array[i] = arr.trim();
			i++;
		}
		return array;
	}
}
