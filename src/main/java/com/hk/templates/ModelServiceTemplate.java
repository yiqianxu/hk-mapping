package com.hk.templates;

import java.io.File;

/**
 * ModelService.vm
 * 
 * @author huangkai
 * @date 2015年8月13日 下午10:39:12
 * @version V1.0
 */
public class ModelServiceTemplate extends AbstractTemplate {

	private String model;

	private String modelpackage;

	public ModelServiceTemplate(String model,String packagename,String classname,
			String modelpackage, File outputFile) {
		this.model = model;
		this.classname = classname;
		this.outputFile = outputFile;
		this.packagename = packagename;
		this.modelpackage = modelpackage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModelpackage() {
		return modelpackage;
	}

	public void setModelpackage(String modelpackage) {
		this.modelpackage = modelpackage;
	}

}
