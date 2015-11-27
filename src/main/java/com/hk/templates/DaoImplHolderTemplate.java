package com.hk.templates;

import java.io.File;
import java.util.List;

import com.hk.entitys.Table;

/**
 * DaoHolder.vm
 * 
 * @author huangkai
 * @date 2015年8月13日 下午11:46:31
 * @version V1.0
 */
public class DaoImplHolderTemplate extends AbstractTemplate {

	private String modelPackage;

	private List<Table> tables;

	public DaoImplHolderTemplate() {

	}

	public DaoImplHolderTemplate(String packagename, String classname,String modelPackage,
			List<Table> tables, File outputFile) {
		this.packagename = packagename;
		this.classname = classname;
		this.modelPackage = modelPackage;
		this.tables = tables;
		this.outputFile = outputFile;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

}
