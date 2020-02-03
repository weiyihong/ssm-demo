package org.layz.hx.spring.jdbc.sqlBuilder;

import org.layz.hx.core.pojo.info.TableClassInfo;
import org.layz.hx.spring.jdbc.pojo.SqlParam;

public interface SqlBuilder {
	String separator = ",";
	/**
	 * sql构建
	 * @param tableClassInfo
	 * @param param
	 * @return
	 */
	StringBuilder buildCacheSql(TableClassInfo tableClassInfo, Object[] param);
	/**
	 * sql构建
	 * @param cacheSql
	 * @param tableClassInfo
	 * @param param
	 * @return
	 */
	SqlParam buildSql(StringBuilder cacheSql,TableClassInfo tableClassInfo, Object[] param);
}
