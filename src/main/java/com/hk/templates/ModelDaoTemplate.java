package com.hk.templates;

import java.io.File;

/**
 * ModelDao.vm
 * 
 * @author huangkai
 * @date 2015年8月13日 下午10:20:58
 * @version V1.0
 */
public class ModelDaoTemplate extends AbstractTemplate {

	private String modelPackage;//com.hk

	private String model;//User

	public ModelDaoTemplate() {

	}

	public ModelDaoTemplate(String model ,String modelPackage, String packagename,
			String classname, File outputFile) {
		this.model = model;
		this.modelPackage = modelPackage;
		this.packagename = packagename;
		this.classname = classname;
		this.outputFile = outputFile;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
