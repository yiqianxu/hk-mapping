package com.hk.core;

import com.hk.utils.ConnectionUtils;


public final class CodeGenerator {
	
	/**
	 * 使用默认配置文件生成
	 */
	public static void generate() {
		TemplateGenerator.generate(ConnectionUtils.getMetaData().getTables());
	}
	
	/**
	 * 指定表生成
	 * @param tables
	 */
	public static void generate(String... tables) {
		System.out.println("指定表生成!");
	}

}
