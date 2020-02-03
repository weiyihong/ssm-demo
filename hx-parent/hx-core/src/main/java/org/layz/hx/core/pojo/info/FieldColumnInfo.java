package org.layz.hx.core.pojo.info;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.util.formater.Dataformater;

public class FieldColumnInfo extends FieldInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -691137215067736228L;
	private HxColumn column;
	private String columnName;
	private Dataformater dataformater;
	
	public HxColumn getColumn() {
		return column;
	}
	
	public void setColumn(HxColumn column) {
		this.column = column;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public Dataformater getDataformater() {
		return dataformater;
	}
	
	public void setDataformater(Dataformater dataformater) {
		this.dataformater = dataformater;
	}
}
