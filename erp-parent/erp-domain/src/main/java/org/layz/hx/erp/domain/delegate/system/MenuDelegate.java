package org.layz.hx.erp.domain.delegate.system;

import org.layz.hx.erp.domain.entity.system.Menu;

import java.util.List;

public interface MenuDelegate {
    /**
     * 角色菜单信息查询
     * @param roleId
     * @return
     */
    Menu queryRoleMenu(Long roleId);

    /**
     * 角色权限查询
     * @param roleId
     * @return
     */
    List<String> queryRolePath(Long roleId);
}
