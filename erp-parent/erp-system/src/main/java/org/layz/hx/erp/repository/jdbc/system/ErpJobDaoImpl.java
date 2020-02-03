package org.layz.hx.erp.repository.jdbc.system;

import org.layz.hx.core.annotation.support.HxTableSupport;
import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.layz.hx.spring.jdbc.repository.BaseJobDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ErpJobDaoImpl extends BaseJobDaoImpl<ErpJobEntity> implements ErpJobDao {

    @Override
    protected void initTemplateConfig() {
        String tableName = HxTableSupport.getTableClassInfo(ErpJobEntity.class).getTableName();
        super.clazz = ErpJobEntity.class;
        setFailCount(5);
        setTableName(tableName);
    }
}
