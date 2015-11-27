package com.hk.templates;

import java.io.File;

/**
 * ModelServiceImpl.vm
 * 
 * @author huangkai
 * @date 2015年8月13日 下午10:38:54
 * @version V1.0
 */
public class ModelServiceImplTemplate extends AbstractTemplate {

	private String model;

	private String modelpackage;

	private String daopackage;

	private String implService;

	private String servicepackage;

	public ModelServiceImplTemplate() {

	}

	public ModelServiceImplTemplate(String implService, String servicepackage,
			String model, String modelpackage, String daopackage,
			String packagename, String classname, File outputFile) {
		this.implService = implService;
		this.servicepackage = servicepackage;
		this.model = model;
		this.modelpackage = modelpackage;
		this.daopackage = daopackage;
		this.packagename = packagename;
		this.classname = classname;
		this.outputFile = outputFile;
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

	public String getDaopackage() {
		return daopackage;
	}

	public void setDaopackage(String daopackage) {
		this.daopackage = daopackage;
	}

	public String getImplService() {
		return implService;
	}

	public String getServicepackage() {
		return servicepackage;
	}

	public void setServicepackage(String servicepackage) {
		this.servicepackage = servicepackage;
	}

	public void setImplService(String implService) {
		this.implService = implService;
	}

}
