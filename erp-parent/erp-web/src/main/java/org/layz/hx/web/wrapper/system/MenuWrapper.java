package org.layz.hx.web.wrapper.system;

import org.layz.hx.erp.domain.entity.system.Menu;

import java.util.List;

public interface MenuWrapper {
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
