package com.hk.core;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hk.exception.ClassWrapperCastException;

/**
 * 类包装器
 * 
 * @author fanlychie
 * @since 1.0.0
 */
public class ClassWrapper {

	private Class<?> beanClass;
	private Map<String, Field> properties;

	public ClassWrapper(Class<?> beanClass) {
		init(beanClass);
	}

	public Class<?> getPropertyType(String propertyName) {
		Field field = properties.get(propertyName);
		if (field != null) {
			return field.getType();
		}
		throw new ClassWrapperCastException(errorOf(propertyName));
	}

	public void setPropertyValue(Object bean, String propertyName, Object propertyValue) {
		Field field = properties.get(propertyName);
		if (field != null) {
			try {
				field.set(bean, propertyValue);
				return ;
			} catch (Throwable e) {
				throw new ClassWrapperCastException(e);
			}
		}
		throw new ClassWrapperCastException(errorOf(propertyName));
	}

	@SuppressWarnings("unchecked")
	public <E> E getPropertyValue(Object bean, String propertyName) {
		Field field = properties.get(propertyName);
		if (field != null) {
			try {
				Object value = field.get(bean);
				if (value == null) {
					return null;
				}
				return (E) value;
			} catch (Throwable e) {
				throw new ClassWrapperCastException(e);
			}
		}
		throw new ClassWrapperCastException(errorOf(propertyName));
	}
	
	public Map<String, Object> getPropertyValues(Object bean) {
		Map<String, Object> props = new HashMap<String, Object>();
		for (String key : properties.keySet()) {
			props.put(key, getPropertyValue(bean, key));
		}
		return props;
	}

	private void init(Class<?> beanClass) {
		this.beanClass = beanClass;
		properties = new HashMap<String, Field>();
		List<Field> list = getReferableNonStaticFields(beanClass);
		for (Field field : list) {
			String name = field.getName();
			if (!properties.containsKey(name)) {
				properties.put(name, field);
			}
		}
	}
	
	public List<Field> getReferableNonStaticFields(Class<?> beanClass) {
		List<Field> fieldList = getReferableFields(beanClass);
		return dropStaticFields(fieldList);
	}
	
	public static List<Field> getReferableFields(Class<?> beanClass) {
		List<Field> list = new ArrayList<Field>();
		while (beanClass != null) {
			List<Field> pojoClassFields = getDeclaredFields(beanClass);
			if (pojoClassFields != null) {
				list.addAll(pojoClassFields);
			}
			beanClass = beanClass.getSuperclass();
		}
		return list;
	}
	
	public static List<Field> getDeclaredFields(Class<?> beanClass) {
		Field[] fields = beanClass.getDeclaredFields();
		if (fields.length == 0) {
			return null;
		}
		for (Field field : fields) {
			field.setAccessible(true);
		}
		return Arrays.asList(fields);
	}
	
	private static List<Field> dropStaticFields(List<Field> origin) {
		List<Field> list = new ArrayList<Field>();
		if (origin != null) {
			for (Field field : origin) {
				if ((field.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
					list.add(field);
				}
			}
		}
		return list;
	}

	private String errorOf(String propertyName) {
		String message = propertyName
				+ " property can not be found in the class : "
				+ beanClass.getSimpleName();
		return message;
	}
	
}