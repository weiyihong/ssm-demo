package org.layz.hx.erp.delegate.system;

import com.alibaba.dubbo.config.annotation.Service;
import org.layz.hx.erp.domain.delegate.system.UserDelegate;
import org.layz.hx.erp.domain.entity.system.User;
import org.layz.hx.erp.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserDelegateImpl implements UserDelegate{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDelegateImpl.class);
	@Autowired
	private UserService userService;
	public User login(String userCode, String passWord) {
		LOGGER.debug("userCode: {}", userCode);
		return userService.login(userCode,passWord);
	}

}
