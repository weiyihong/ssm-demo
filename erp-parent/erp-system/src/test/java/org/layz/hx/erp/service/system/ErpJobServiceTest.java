package org.layz.hx.erp.service.system;

import org.junit.Test;
import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.core.enums.type.JobStatusEnum;
import org.layz.hx.erp.BaseJunitTest;
import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ErpJobServiceTest extends BaseJunitTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErpJobServiceTest.class);
    @Autowired
    private ErpJobService erpJobService;
    @Test
    public void findCountByNameTest(){
        int count = erpJobService.findCountByName("erpTask");
        LOGGER.debug("count:{}", count);
    }
    @Test
    public void update(){
        int i = erpJobService.updateProcessNo("erpTask_153946605568", "erpTask", 1);
        LOGGER.debug("count : {}", i);
    }
    @Test
    public void persistEntityTest(){
        for (int i = 0; i <1<< 6; i++) {
            ErpJobEntity erpJobEntity = new ErpJobEntity();
            erpJobEntity.setScanTypeName("erpTask");
            erpJobEntity.setTaskService("testTaskServiceImpl");
            erpJobEntity.setStatus(JobStatusEnum.WAITE_HANDLE.getValue());
            erpJobEntity.setFailCount(0);
            erpJobEntity.setBeginRunTime(new Date());
            erpJobEntity.setDeleted(DisableEnum.ENABLE.getValue());
            erpJobEntity.setCreatedBy(1L);
            erpJobEntity.setLastModifiedBy(1L);
            erpJobService.persistEntity(erpJobEntity);
        }
    }
    @Test
    public void findByIdTest(){
        ErpJobEntity byId = erpJobService.findById(2L);
        LOGGER.debug("");
    }
}
