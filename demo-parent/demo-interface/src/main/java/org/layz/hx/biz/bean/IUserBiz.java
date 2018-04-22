package org.layz.hx.biz.bean;

import java.util.List;

import org.layz.hx.common.bean.User;

public interface IUserBiz {
	/**
	 * 获取用户列表
	 * @return
	 */
	public List<User> getUserList();
	/**
	 * 根据Id查询用户信息
	 * @param userId
	 * @return
	 */
	public User getUserById(Long userId);
}
