package org.layz.hx.core.annotation.support;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxSupperClass;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.pojo.info.FieldColumnInfo;
import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.core.util.converter.DataConverter;
import org.layz.hx.core.util.factory.DataConverterFactory;
import org.layz.hx.core.util.factory.DataformaterFactory;
import org.layz.hx.core.util.formater.Dataformater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HxTableSupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(HxTableSupport.class);
	private static final Map<Object,TableClassInfo> store = new ConcurrentHashMap<>();
	/**
	 * _获取领域模型对象
	 * @param clazz
	 * @return
	 */
	public static TableClassInfo getTableClassInfo(Class<?> clazz) {
		if(null == clazz) {
			return null;
		}
		TableClassInfo cacheInfo = store.get(clazz);
		if(null != cacheInfo) {
			return cacheInfo;
		}
		LOGGER.info("getTableClassInfo, clazz: {}", clazz);
		HxTable table = null;
		String tableName = null,id = "id";
		if(clazz.isAnnotationPresent(HxTable.class)) {
			LOGGER.debug("obtain HxTable table");
			table = clazz.getAnnotation(HxTable.class);
			tableName = table.value();
			id = table.id();
		}
		if(null == tableName || tableName.length() < 1) {
			tableName = clazz.getSimpleName();
		}
		List<FieldColumnInfo> fieldList = new ArrayList<FieldColumnInfo>();
		obtainFieldList(fieldList,clazz);
		fieldList.sort(Comparator.comparing(o -> o.getColumn().sort()));
		
		cacheInfo = new TableClassInfo();
		cacheInfo.setTable(table);
		cacheInfo.setClazz(clazz);
		cacheInfo.setTableName(tableName);
		cacheInfo.setId(id);
		cacheInfo.setFieldList(fieldList);

		store.put(clazz,cacheInfo);
		return cacheInfo;
	}
	/**
	 * _设置字段信息
	 * @param fieldList
	 * @param clazz
	 */
	private static void obtainFieldList(List<FieldColumnInfo> fieldList, Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			try {
				if(!field.isAnnotationPresent(HxColumn.class)) {continue;}
				HxColumn column = field.getAnnotation(HxColumn.class);
				Class<?> fieldType = field.getType();
				
				String fieldName = field.getName();
				String setMethodName = String.format("set%s%s", fieldName.substring(0,1).toUpperCase(),fieldName.substring(1));
				String getMethodName = String.format("get%s%s", fieldName.substring(0,1).toUpperCase(),fieldName.substring(1));
				Method methodGet = clazz.getMethod(getMethodName);
				Method methodSet = clazz.getMethod(setMethodName, fieldType);
				
				String columnName = column.value();
				if(columnName.length() < 1) {
					columnName = fieldName;
				}
				
				String formaterType = column.formaterType();
				String formaterName = column.param();
				Dataformater dataformater = DataformaterFactory.getDataformater(formaterType, formaterName);
				
				DataConverter converter = DataConverterFactory.getConverter(fieldType);
				
				FieldColumnInfo fieldInfo = new FieldColumnInfo();
				fieldInfo.setColumn(column);
				fieldInfo.setFieldName(fieldName);
				fieldInfo.setFieldType(fieldType);
				fieldInfo.setMethodGet(methodGet);
				fieldInfo.setMethodSet(methodSet);
				fieldInfo.setColumnName(columnName);
				fieldInfo.setDataformater(dataformater);
				fieldInfo.setDataConverter(converter);
				fieldList.add(fieldInfo);
			} catch (Exception e) {
				LOGGER.error("obtain FieldColumnInfo error,fieldName: {}",field.getName(), e);
			}
		}
		Class<?> superclass = clazz.getSuperclass();
		if(superclass.isAnnotationPresent(HxSupperClass.class)) {
			obtainFieldList(fieldList, superclass);
		}
	}
}
