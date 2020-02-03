package org.layz.hx.spring.jdbc.sqlBuilder;

import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;

public class CountByEntitySqlBuilder extends AbstractSqlBuilder{

	@Override
	public SqlParam buildSql(StringBuilder cacheSql, TableClassInfo tableClassInfo, Object[] param) {
		cacheSql = new StringBuilder("select count(0) total from ").append(tableClassInfo.getTableName());
		return buildWhereSql(cacheSql, tableClassInfo, param);
	}

}
