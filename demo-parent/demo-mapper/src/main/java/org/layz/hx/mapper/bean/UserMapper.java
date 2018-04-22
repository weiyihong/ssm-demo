package org.layz.hx.mapper.bean;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.layz.hx.common.bean.User;

public interface UserMapper {
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
	public User getUserByid(@Param("userId")Long userId);
}
