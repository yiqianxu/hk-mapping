package com.hk.entitys;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author huangkai
 * @date 2015年8月1日 下午7:26:42
 * @version V1.0
 */
public class Table implements Comparable<Table>  {

	private String name;
	private String originName;
	private String primaryKey;
	private String originPrimaryKey;
	private List<Column> columns;
	private Map<String, String> colMap;

	public Table(String name, String primaryKey, List<Column> columns) {
//		this.name = name.substring(2);
		this.name = name;
		this.originName = name;
		this.columns = columns;
		this.primaryKey = primaryKey;
		this.originPrimaryKey = primaryKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public Map<String, String> getColMap() {
		return colMap;
	}

	public void setColMap(Map<String, String> colMap) {
		this.colMap = colMap;
	}

	public String getOriginPrimaryKey() {
		return originPrimaryKey;
	}

	public void setOriginPrimaryKey(String originPrimaryKey) {
		this.originPrimaryKey = originPrimaryKey;
	}

	@Override
	public int compareTo(Table o) {
		return this.name.compareTo(o.name);
	}

}
