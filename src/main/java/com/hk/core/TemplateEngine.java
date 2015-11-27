package com.hk.core;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.hk.exception.TemplateEngineCastException;
import com.hk.templates.Template;
import com.hk.utils.ImportVar;
import com.hk.utils.Utilities;

public class TemplateEngine {
	
	private static final Utilities UTILITIES = new Utilities();
	
	private static final String CLASS_PATH = "classpath";
	
	private static final String CLASSPATH_RESOURCE_LOADER = "classpath.resource.loader.class";
	
	private static final String TEMPLATE_FILE_DIR = "/com/hk/conf/templates/";
	
	public String parseTemplate(Template template) {
		Thread thread = Thread.currentThread();
		ClassLoader loader = thread.getContextClassLoader();
		thread.setContextClassLoader(this.getClass().getClassLoader());
		StringWriter writer = new StringWriter();
		String templatePathname = getTemplatePathname(template);
		try {
			VelocityEngine engine = getVelocityEngine();
			engine.getTemplate(templatePathname).merge(buildContext(template),writer);
			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new TemplateEngineCastException(
					"can not parse the template : "
							+ getTemplatePathname(template), e);
		}finally {
			thread.setContextClassLoader(loader);
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private Context buildContext(Template template) {
		VelocityContext context = new VelocityContext();
		ClassWrapper wraper = Wrapper.warp(template);
		Map<String, Object> props = wraper.getPropertyValues(template);
		for (String prop : props.keySet()) {
			context.put(prop, props.get(prop));
		}
		context.put("util", UTILITIES);
		context.put("imports", ImportVar.getVar());
		return context;
	}

	private VelocityEngine getVelocityEngine() throws Exception {
		Properties prop = new Properties();
		prop.put(RuntimeConstants.RESOURCE_LOADER, CLASS_PATH);
		prop.put(CLASSPATH_RESOURCE_LOADER, ClasspathResourceLoader.class.getName());
		VelocityEngine engine = new VelocityEngine();
		engine.init(prop);
		return engine;
	}

	private String getTemplatePathname(Template template) {
		String templateClass = template.getClass().getSimpleName();
		String templateName = templateClass.substring(0,templateClass.indexOf("Template"));
		return TEMPLATE_FILE_DIR + templateName + ".vm";
	}
	
}
