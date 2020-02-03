package org.layz.hx.erp.domain.delegate.system;

import org.layz.hx.erp.domain.entity.system.Role;

public interface RoleDelegate {
    /**
     * 角色切换
     * @param userId
     * @param roleId
     * @return
     */
    Role changeRole(Long userId, Long roleId);
}
