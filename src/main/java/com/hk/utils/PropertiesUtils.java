package com.hk.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.hk.exception.MMGenCastException;

public final class PropertiesUtils {
	
	private static final Map<String, String> CONFIG_MAP = new HashMap<String, String>();
	
	private static final String CONFIG_PROPERTIES  = "config.properties"; 
	
	static {
		init();
	}

	private static void init() {
		CONFIG_MAP.putAll(PropertiesAssistant.load(CONFIG_PROPERTIES));
	}
	
	public static String get(String key) {
		return CONFIG_MAP.get(key);
	}
	
	
	private static class  PropertiesAssistant {
		
		private static final Map<String, String> MAP = new HashMap<String, String>();
		
		public static Map<String, String> load(String filePath) {
			InputStream in = ClassLoader.getSystemResourceAsStream(filePath);
			if (in == null) {
				throw new MMGenCastException(new FileNotFoundException(String.format("can not found file :[ %s ]", filePath)));
			}
			Properties properties = new Properties();
			try {
				properties.load(in);
				for (Object key : properties.keySet()) {	
					MAP.put(key.toString(), properties.get(key).toString());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if( in != null)
					try {
						in.close();
					} catch (Exception e) {
						e.printStackTrace();
				}
			}
			return MAP;
		}
	}

}
