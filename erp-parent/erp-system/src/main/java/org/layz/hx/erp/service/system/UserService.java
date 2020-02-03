package org.layz.hx.erp.service.system;

import org.layz.hx.erp.domain.entity.system.User;
import org.layz.hx.spring.jdbc.service.BaseService;

public interface UserService extends BaseService<User> {
    /**
     * 登录
     * @param userCode
     * @param passWord
     * @return
     */
    User login(String userCode, String passWord);

    /**
     * 默认角色设置
     * @param userId
     * @param roleId
     */
    void persistDefaultRole(Long userId, Long roleId);
}
