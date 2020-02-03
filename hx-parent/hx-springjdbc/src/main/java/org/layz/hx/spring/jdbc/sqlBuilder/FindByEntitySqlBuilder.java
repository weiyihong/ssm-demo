package org.layz.hx.spring.jdbc.sqlBuilder;

import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindByEntitySqlBuilder extends AbstractSqlBuilder{
	private static final Logger LOGGER = LoggerFactory.getLogger(FindByEntitySqlBuilder.class);
	@Override
	public StringBuilder buildCacheSql(TableClassInfo tableClassInfo, Object[] param) {
		LOGGER.debug("buildCacheSql,class: {}", tableClassInfo.getClazz());
		StringBuilder stringBuilder = builderSelect(tableClassInfo);
		return stringBuilder;
	}

	@Override
	public SqlParam buildSql(StringBuilder cacheSql, TableClassInfo tableClassInfo, Object[] param) {
		return buildWhereSql(cacheSql, tableClassInfo, param);
	}

}
