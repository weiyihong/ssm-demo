package org.layz.hx.erp.service.system;

import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.layz.hx.erp.repository.jdbc.system.ErpJobDao;
import org.layz.hx.spring.jdbc.repository.BaseJobDao;
import org.layz.hx.spring.jdbc.service.BaseJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpJobServiceImpl extends BaseJobServiceImpl<ErpJobEntity> implements ErpJobService {
    @Autowired
    private ErpJobDao erpJobDao;

    @Override
    public BaseJobDao<ErpJobEntity> getBaseDao() {
        return erpJobDao;
    }
}
