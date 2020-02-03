package org.layz.hx.erp.service.system;

import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.entity.system.User;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.erp.repository.jdbc.system.UserDao;
import org.layz.hx.spring.jdbc.repository.BaseDao;
import org.layz.hx.spring.jdbc.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String userCode, String passWord) {
        LOGGER.debug("userCode: {}", userCode);
        // 会员信息查询
        User param = new User();
        param.setUserCode(userCode);
        param.setPassWord(passWord);
        List<User> userList = userDao.findByEntity(param);
        Assert.isNotEmpty(userList,ErpSystemEnum.LOGIN_INPUT_ERROR);
        final User user = userList.get(0);
        Assert.isTrue(DisableEnum.ENABLE.equalValue(user.getDeleted()),ErpSystemEnum.LOGIN_INPUT_ERROR);
        // 角色信息查询
        List<Role> roleList = roleService.queryUserRole(user.getId(),DisableEnum.ENABLE);
        Assert.isNotEmpty(roleList,ErpSystemEnum.USER_ROLE_EMPTY);
        Role role = roleList.stream().filter(o -> o.getId().equals(user.getDefaultRoleId())).findAny().orElse(roleList.get(0));
        user.setDefaultRole(role);

        return user;
    }

    @Override
    @Transactional
    public void persistDefaultRole(Long userId, Long roleId) {
        User user = this.findById(userId);
        Assert.isNotNull(user,ErpSystemEnum.USER_NOT_EXSIST);
        user.setDefaultRoleId(roleId);
        user.setLastModifiedDate(new Date());
        user.setLastModifiedBy(userId);
        this.update(user);
    }

    @Override
    public BaseDao<User> getBaseDao() {
        return userDao;
    }
}
