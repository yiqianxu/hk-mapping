package com.hk.templates;

import java.io.File;
import java.util.List;

import com.hk.entitys.Table;

/**
 * ModelHolder.vm
 * 
 * @author huangkai
 * @date 2015年8月13日 下午10:12:12
 * @version V1.0
 */
public class ModelHolderTemplate extends AbstractTemplate {

	private List<Table> tables;

	private List<String> ignoreColumns;

	public ModelHolderTemplate() {

	}

	public ModelHolderTemplate(String packagename, String classname,
			List<Table> tables, List<String> ignoreColumns, File outputFile) {
		this.packagename = packagename;
		this.classname = classname;
		this.tables = tables;
		this.ignoreColumns = ignoreColumns;
		this.outputFile = outputFile;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<String> getIgnoreColumns() {
		return ignoreColumns;
	}

	public void setIgnoreColumns(List<String> ignoreColumns) {
		this.ignoreColumns = ignoreColumns;
	}

}
