package com.hk.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.hk.entitys.Column;
import com.hk.entitys.Table;
import com.hk.exception.MetaDataCastException;
import com.hk.utils.ImportVar;
import com.hk.utils.TableAssistant;

public class MetaData {

	private Connection connection;

	private DatabaseMetaData databaseMetaData;

	public MetaData(Connection connection) {
		this.connection = connection;
		try {
			databaseMetaData = connection.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MetaDataCastException(e);
		}
	}

	public List<Table> getTables() {
		ResultSet rs = null;
		List<Table> tables = new ArrayList<Table>();
		try {
			rs = databaseMetaData.getTables(null, "%", "%",
					new String[] { "TABLE" });
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME");
				tables.add(new Table(tableName, getPrimaryKey(tableName),
						getColumns(tableName)));
			}
			return TableAssistant.spellingCorrect(tables);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MetaDataCastException(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
					connection = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String getPrimaryKey(String tableName) throws SQLException {
		ResultSet rs = databaseMetaData.getPrimaryKeys(null, null, tableName);
		if (rs.next()) {
			return rs.getString("COLUMN_NAME");
		}
		return null;
	}

	private List<Column> getColumns(String tableName) throws SQLException {
		ResultSet rs = null;
		List<Column> columns = new ArrayList<Column>();
		rs = databaseMetaData.getColumns(null, "%", tableName, "%");
		while (rs.next()) {
			columns.add(new Column(rs.getString("COLUMN_NAME"), getClassName(rs
					.getInt("DATA_TYPE")), rs.getString("REMARKS")));
		}
		return columns;
	}

	private String getClassName(int type) {
		switch (type) {
		case Types.BIT:
		case Types.BOOLEAN:
			return "Boolean";
			
		case Types.TINYINT:
		case Types.SMALLINT:
			return "Integer";
			
		case Types.INTEGER:
		case Types.BIGINT:
			return "Long";
			
//		case Types.INTEGER:
//			ImportVar.put("java.math.BigInteger");
//			return "BigInteger";
			
		case Types.DECIMAL:
		case Types.NUMERIC:
			ImportVar.put("java.math.BigDecimal");
			return "BigDecimal";
			
		case Types.REAL:
			return "Float";
			
		case Types.FLOAT:
		case Types.DOUBLE:
			return "Double";
			
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
		case Types.BINARY:
		case Types.VARBINARY:
		case Types.LONGVARBINARY:
			return "String";
			
		case Types.DATE:
		case Types.TIME:
		case Types.TIMESTAMP:
			ImportVar.put("java.util.Date");
			return "Date";
		default:
			return "Object";
		}
	}

}
