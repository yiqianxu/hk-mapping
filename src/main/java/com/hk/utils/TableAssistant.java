package com.hk.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hk.entitys.Column;
import com.hk.entitys.Table;

public class TableAssistant {

	private static final String SEPARATOR = "_";

	public static List<Table> spellingCorrect(List<Table> tables) {
		List<Table> activeTables;
		List<String> ignoreTables = SpellingIgnore.ignoreTables();
		if (ignoreTables == null) {
			activeTables = tables;
		} else {
			activeTables = new ArrayList<Table>();
			for (Table table : tables) {
				if (!ignoreTables.contains(table.getName())) {
					activeTables.add(table);
				}
			}
		}
		for (Table table : activeTables) {
			spellingCorrect(table);
		}
		Collections.sort(activeTables);
		return activeTables;
	}

	/**
	 * 去掉表名和字段中的下划线
	 * @param table
	 * @return
	 */
	private static Table spellingCorrect(Table table) {
		table.setName(Utilities.capitalize(table.getName(), SEPARATOR));
		table.setPrimaryKey(Utilities.capitalize(table.getPrimaryKey(),
				SEPARATOR, false));
		Map<String, String> colMap = new HashMap<String, String>();
		String originColumnName;
		for (Column column : table.getColumns()) {
			originColumnName = column.getName();
			column.setName(Utilities.capitalize(originColumnName, SEPARATOR,
					false));
			colMap.put(column.getName(), originColumnName);
		}
		table.setColMap(colMap);
		Collections.sort(table.getColumns());
		return table;
	}
}
