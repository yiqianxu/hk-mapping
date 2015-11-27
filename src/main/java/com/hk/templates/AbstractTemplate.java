package com.hk.templates;

import java.io.File;

public abstract class AbstractTemplate implements Template {

	protected File outputFile;  //输出

	protected String classname; // 类名

	protected String packagename; //包名

	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

}
