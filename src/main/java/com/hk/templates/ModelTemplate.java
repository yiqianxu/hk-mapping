package com.hk.templates;

import java.io.File;

/**
 * model.vm
 * @author huangkai
 * @date 2015年8月13日 下午10:29:40
 * @version V1.0
 */
public class ModelTemplate extends AbstractTemplate {

	public ModelTemplate() {

	}

	public ModelTemplate(String packagename,
			String classname, File outputFile) {
		this.packagename = packagename;
		this.classname = classname;
		this.outputFile = outputFile;
	}
}
