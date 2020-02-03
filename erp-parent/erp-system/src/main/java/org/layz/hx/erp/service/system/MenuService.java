package org.layz.hx.erp.service.system;

import org.layz.hx.erp.domain.entity.system.Menu;
import org.layz.hx.spring.jdbc.service.BaseService;

import java.util.List;

public interface MenuService extends BaseService<Menu> {
    /**
     * 角色菜单信息查询
     * @param roleId
     * @return
     */
    List<Menu> queryRoleMenu(Long roleId);
}
