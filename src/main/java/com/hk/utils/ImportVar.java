package com.hk.utils;

import java.util.HashSet;
import java.util.Set;

public class ImportVar {
	
	private static Set<String> vars = new HashSet<String>();
	
	public static void put(String value) {
		vars.add(value);
	}
	
	public static Set<String> getVar() {
		return vars;
	}

}
