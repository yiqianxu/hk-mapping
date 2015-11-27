package com.hk.templates;

import java.io.File;


/**
 * 
 * ModelDaoImpl.vm
 */
public class ModelDaoImplTemplate extends AbstractTemplate{

	private String daoPackage;
	
	private String implDao;
	
	public ModelDaoImplTemplate() {
		
	}
	
	public ModelDaoImplTemplate(String daoPackage,String implDao,String packagename ,String classname,File outputFile) {
		this.daoPackage = daoPackage;
		this.implDao = implDao;
		this.packagename = packagename;
		this.classname = classname;
		this.outputFile = outputFile;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getImplDao() {
		return implDao;
	}

	public void setImplDao(String implDao) {
		this.implDao = implDao;
	}
	
	
}
