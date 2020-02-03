package org.layz.hx.erp.service.system;

import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.erp.repository.jdbc.system.RoleDao;
import org.layz.hx.erp.repository.mapper.system.RoleMapper;
import org.layz.hx.spring.jdbc.repository.BaseDao;
import org.layz.hx.spring.jdbc.service.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserService userService;

    @Override
    public List<Role> queryUserRole(Long userId, DisableEnum enable) {
        Assert.isNotNull(userId, ErpSystemEnum.USER_ID_ISNULL);
        List<Role> roleList = roleMapper.queryUserRole(userId,enable.getValue());
        return roleList;
    }

    @Override
    public Role changeRole(Long userId, Long roleId) {
        LOGGER.debug("roleId: {}, userId: {}", roleId, userId);
        List<Role> roleList = this.queryUserRole(userId, DisableEnum.ENABLE);
        Assert.isNotEmpty(roleList,ErpSystemEnum.USER_ROLE_EMPTY);
        Role role = roleList.stream().filter(o -> roleId.equals(o.getId())).findAny().orElse(null);
        Assert.isNotNull(role, ErpSystemEnum.ROLE_IS_ERROR);
        userService.persistDefaultRole(userId,roleId);
        return role;
    }

    @Override
    public BaseDao<Role> getBaseDao() {
        return roleDao;
    }
}
