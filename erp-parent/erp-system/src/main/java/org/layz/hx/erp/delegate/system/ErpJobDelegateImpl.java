package org.layz.hx.erp.delegate.system;

import com.alibaba.dubbo.config.annotation.Service;
import org.layz.hx.erp.domain.delegate.system.ErpJobDelegate;
import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.layz.hx.erp.service.system.ErpJobService;
import org.layz.hx.spring.jdbc.delegate.BaseJobDelegateImpl;
import org.layz.hx.spring.jdbc.service.BaseJobService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
class ErpJobDelegateImpl extends BaseJobDelegateImpl<ErpJobEntity> implements ErpJobDelegate {
    @Autowired
    private ErpJobService erpJobService;

    @Override
    public BaseJobService<ErpJobEntity> getService() {
        return erpJobService;
    }

    @Override
    public ErpJobEntity getInstance() {
        return new ErpJobEntity();
    }
}
