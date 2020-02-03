package org.layz.hx.core.util.formater;

import java.util.Map;

import org.layz.hx.core.pojo.info.FieldColumnInfo;

public interface Dataformater {
	String DEFAULT = "FORMATER_DEFAULT";
	String CONTEXT = "FORMATER_CONTEXT";
	/**
	 * 支持的数据
	 * @param formatType
	 * @return
	 */
	boolean support(String formatType);
		
	/**
	 * 数据转换
	 * @param object
	 * @param fieldInfo
	 * @param cache
	 * @return
	 */
	Object format(Object object,FieldColumnInfo fieldInfo, Map<Object, Object> cache);
}
