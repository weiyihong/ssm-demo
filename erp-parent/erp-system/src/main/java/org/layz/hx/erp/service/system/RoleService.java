package org.layz.hx.erp.service.system;

import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.spring.jdbc.service.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    /**
     * 查询会员有效的角色信息
     * @param userId
     * @param enable
     * @return
     */
    List<Role> queryUserRole(Long userId, DisableEnum enable);

    /**
     * 角色切换
     * @param userId
     * @param roleId
     * @return
     */
    Role changeRole(Long userId, Long roleId);
}
