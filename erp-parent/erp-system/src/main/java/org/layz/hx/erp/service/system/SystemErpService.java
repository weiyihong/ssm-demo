package org.layz.hx.erp.service.system;

import org.layz.hx.erp.domain.entity.system.SystemErp;
import org.layz.hx.spring.jdbc.service.BaseService;

import java.util.List;

public interface SystemErpService extends BaseService<SystemErp> {
    /**
     * 用户权限查询
     * @param userId
     * @return
     */
    List<SystemErp> queryUserAuth(Long userId);
}
