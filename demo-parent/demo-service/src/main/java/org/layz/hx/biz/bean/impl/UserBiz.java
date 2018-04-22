package org.layz.hx.biz.bean.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.layz.hx.biz.bean.IUserBiz;
import org.layz.hx.common.bean.User;
import org.layz.hx.mapper.bean.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserBiz implements IUserBiz{
	private static final Logger logger = Logger.getLogger(UserBiz.class);
	@Autowired
	private UserMapper userMapper;
	/**
	 * 获取用户列表
	 * @return
	 */
	@Cacheable(value="USER_CACHE")
	public List<User> getUserList(){
		logger.info("获取列表");
		return userMapper.getUserList();
	}
	/**
	 * 根据Id查询用户信息
	 * @param userId
	 * @return
	 */
	public User getUserById(Long userId){
		return userMapper.getUserByid(userId);
	}
}
