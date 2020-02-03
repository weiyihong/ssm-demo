package org.layz.hx.core.pojo.info;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.layz.hx.core.util.converter.DataConverter;

public class FieldInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8304306633400926502L;
	private String fieldName;
	private Class<?> fieldType;
	private DataConverter dataConverter;
	private Method methodGet;
	private Method methodSet;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Class<?> getFieldType() {
		return fieldType;
	}
	public void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}
	public Method getMethodGet() {
		return methodGet;
	}
	public void setMethodGet(Method methodGet) {
		this.methodGet = methodGet;
	}
	public Method getMethodSet() {
		return methodSet;
	}
	public void setMethodSet(Method methodSet) {
		this.methodSet = methodSet;
	}
	public DataConverter getDataConverter() {
		return dataConverter;
	}
	public void setDataConverter(DataConverter dataConverter) {
		this.dataConverter = dataConverter;
	}
}
