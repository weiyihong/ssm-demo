package org.layz.hx.erp.delegate.system;

import com.alibaba.dubbo.config.annotation.Service;
import org.layz.hx.erp.domain.delegate.system.SystemErpDelegate;
import org.layz.hx.erp.domain.entity.system.SystemErp;
import org.layz.hx.erp.service.system.SystemErpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SystemErpDelegateImpl implements SystemErpDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemErpDelegateImpl.class);
    @Autowired
    private SystemErpService systemErpService;
    @Override
    public List<SystemErp> queryUserAuth(Long userId) {
        LOGGER.debug("userId: {}", userId);
        return systemErpService.queryUserAuth(userId);
    }
}
