package org.layz.hx.spring.jdbc.sqlBuilder;

import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;

public class DeleteByIdSqlBuilder extends AbstractSqlBuilder{

	@Override
	public StringBuilder buildCacheSql(TableClassInfo tableClassInfo, Object[] param) {
		return new StringBuilder("delete from ")
				.append(tableClassInfo.getTableName())
				.append(" where ")
				.append(tableClassInfo.getId())
				.append(" = ? ;");
	}

	@Override
	public SqlParam buildSql(StringBuilder cacheSql, TableClassInfo tableClassInfo, Object[] param) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.setSql(cacheSql.toString());
		return sqlParam;
	}

}
