package org.layz.hx.erp.domain.delegate.system;

import org.layz.hx.erp.domain.entity.system.SystemErp;

import java.util.List;

public interface SystemErpDelegate {
    /**
     * 用户权限信息查询
     * @param userId
     * @return
     */
    List<SystemErp> queryUserAuth(Long userId);
}
