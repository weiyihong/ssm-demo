package org.layz.hx.spring.jdbc.pojo;

public class SqlParam {
	private String sql;
	private Object[] args;
	
	public String getSql() {
		return sql;
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public Object[] getArgs() {
		return args;
	}
	
	public void setArgs(Object[] args) {
		this.args = args;
	}
}
