package com.hk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hk.core.MetaData;
import com.hk.exception.MMGenCastException;

public class ConnectionUtils {
	
	private static String url ;
	
	private static String driver;
	
	private static String username;
	
	private static String password;
	
	static {
		init();
	}
	
	public static MetaData getMetaData() {
		return new MetaData(getConnection());
	}

	private static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MMGenCastException(e);
		}
	}

	private static void init() {
		url = PropertiesUtils.get("jdbc.url");
		driver = PropertiesUtils.get("jdbc.driver");
		username = PropertiesUtils.get("jdbc.username");
		password = PropertiesUtils.get("jdbc.password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new MMGenCastException(e);
		}
	}

}
