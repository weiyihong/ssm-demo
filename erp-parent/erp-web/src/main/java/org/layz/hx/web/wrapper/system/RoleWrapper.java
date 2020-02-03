package org.layz.hx.web.wrapper.system;

import org.layz.hx.erp.domain.entity.system.vo.LoginVo;

public interface RoleWrapper {
    /**
     * 角色切换
     * @param roleId
     */
    LoginVo change(Long roleId);
}
