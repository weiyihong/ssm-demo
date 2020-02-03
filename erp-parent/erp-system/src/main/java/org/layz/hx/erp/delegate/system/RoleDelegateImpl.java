package org.layz.hx.erp.delegate.system;

import com.alibaba.dubbo.config.annotation.Service;
import org.layz.hx.erp.domain.delegate.system.RoleDelegate;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.service.system.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleDelegateImpl implements RoleDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDelegateImpl.class);
    @Autowired
    private RoleService roleService;
    @Override
    public Role changeRole(Long userId, Long roleId) {
        LOGGER.debug("roleId: {}, userId: {}", roleId, userId);
        return roleService.changeRole(userId,roleId);
    }
}
