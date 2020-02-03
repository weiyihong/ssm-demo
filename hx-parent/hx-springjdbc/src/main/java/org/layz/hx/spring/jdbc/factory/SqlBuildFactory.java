package org.layz.hx.spring.jdbc.factory;

import org.layz.hx.core.annotation.support.HxTableSupport;
import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;
import org.layz.hx.spring.jdbc.sqlBuilder.SqlBuilder;

import java.util.Map;

public class SqlBuildFactory {
	private Map<String, SqlBuilder> store;
	
	public SqlParam buildSql(Class<?> clazz,String key, Object... param) {
		TableClassInfo tableClassInfo = HxTableSupport.getTableClassInfo(clazz);
		SqlBuilder builder = store.get(key);
		StringBuilder sqlBuilder = builder.buildCacheSql(tableClassInfo, param);
		SqlParam sqlParam = builder.buildSql(sqlBuilder,tableClassInfo,param);
		return sqlParam;
	}

	public void setStore(Map<String, SqlBuilder> store) {
		this.store = store;
	}
}
