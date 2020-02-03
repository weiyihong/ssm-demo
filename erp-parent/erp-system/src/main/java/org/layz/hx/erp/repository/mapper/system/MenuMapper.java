package org.layz.hx.erp.repository.mapper.system;

import org.layz.hx.erp.domain.entity.system.Menu;

import java.util.List;

public interface MenuMapper {
    /**
     * 系统菜单信息查询
     * @param sysId
     * @return
     */
    List<Menu> findSystemMenu(Long sysId);

    /**
     * 角色菜单信息查询
     * @param roleId
     * @return
     */
    List<Menu> findRoleMenu(Long roleId);
}
