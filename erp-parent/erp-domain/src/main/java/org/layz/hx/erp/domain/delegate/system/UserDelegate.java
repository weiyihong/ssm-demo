package org.layz.hx.erp.domain.delegate.system;

import org.layz.hx.erp.domain.entity.system.User;

public interface UserDelegate {
	/**
	 * 登录
	 * @param userCode
	 * @param passWord
	 * @return
	 */
	User login(String userCode, String passWord);
}
