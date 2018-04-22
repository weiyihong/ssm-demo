package org.layz.hx.controller.bean;

import java.util.List;

import org.apache.log4j.Logger;
import org.layz.hx.biz.bean.IUserBiz;
import org.layz.hx.common.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private IUserBiz userBiz;
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<User> getUserList(){
		logger.info("controller.......");
		return userBiz.getUserList();
	}
	
}
