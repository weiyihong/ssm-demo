package org.layz.hx.spring.jdbc.sqlBuilder;

import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindByIdSqlBuilder extends AbstractSqlBuilder{
	private static final Logger LOGGER = LoggerFactory.getLogger(FindByIdSqlBuilder.class);
	@Override
	public StringBuilder buildCacheSql(TableClassInfo tableClassInfo, Object[] param) {
		LOGGER.info("buildCacheSql,class: {}", tableClassInfo.getClazz());
		StringBuilder stringBuilder = builderSelect(tableClassInfo);
		return stringBuilder.append(" where ")
			.append(tableClassInfo.getId())
			.append(" = ?");
	}

	@Override
	public SqlParam buildSql(StringBuilder cacheSql, TableClassInfo tableClassInfo, Object[] param) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.setSql(cacheSql.toString());
		sqlParam.setArgs(param);
		return sqlParam;
	}

}
