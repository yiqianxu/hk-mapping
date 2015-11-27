package com.hk.core;

public class Configuration {

	private String url;

	private String driver;

	private String username;

	private String password;

	private String rootdir;

	private String modelPackage;

	private String daoPackage;

	private String daoImplPackage;

	private String servicePackage;

	private String serviceImplPackage;

	private String ignoreTables;

	private String ignoreColumns;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRootdir() {
		return rootdir;
	}

	public void setRootdir(String rootdir) {
		this.rootdir = rootdir;
	}

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

	public String getDaoImplPackage() {
		return daoImplPackage;
	}

	public void setDaoImplPackage(String daoImplPackage) {
		this.daoImplPackage = daoImplPackage;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getServiceImplPackage() {
		return serviceImplPackage;
	}

	public void setServiceImplPackage(String serviceImplPackage) {
		this.serviceImplPackage = serviceImplPackage;
	}

	public String getIgnoreTables() {
		return ignoreTables;
	}

	public void setIgnoreTables(String ignoreTables) {
		this.ignoreTables = ignoreTables;
	}

	public String getIgnoreColumns() {
		return ignoreColumns;
	}

	public void setIgnoreColumns(String ignoreColumns) {
		this.ignoreColumns = ignoreColumns;
	}

}
