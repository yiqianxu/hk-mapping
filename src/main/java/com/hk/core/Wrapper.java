package com.hk.core;

public class Wrapper {
	
	public static ClassWrapper warp(Object target) {
		Class<?> clazz ;
		if(target instanceof Class) {
			clazz = (Class<?>) target ;
		} else {
			clazz = target.getClass();
		}
		return new ClassWrapper(clazz);
	}

}
