package org.layz.hx.erp.domain.enums.common;

import org.layz.hx.core.enums.SessionEnum;

public enum ErpSessionEnum implements SessionEnum {
	LOGIN_INFO("session_login_info");
	private String value;
	ErpSessionEnum(String value){
		this.value = value;
	}
	@Override
	public String getValue() {
		return value;
	}
}
