package org.layz.hx.spring.jdbc.service;

import org.layz.hx.core.entity.BaseJobEntity;
import org.layz.hx.spring.jdbc.repository.BaseJobDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public abstract class BaseJobServiceImpl<T extends BaseJobEntity> extends BaseServiceImpl<T> implements  BaseJobService<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseJobServiceImpl.class);

    public abstract BaseJobDao<T> getBaseDao();

    @Override
    public int findCountByName(String scanTypeName) {
        int count = getBaseDao().findCountByName(scanTypeName,new Date());
        LOGGER.debug("count:{}", count);
        return count;
    }

    @Override
    @Transactional
    public int updateProcessNo(String processNo, String scanTypeName, Integer taskLoopCount) {
        LOGGER.debug("scanTypeName: {},taskLoopCount: {},processNo: {}", scanTypeName, taskLoopCount, processNo);
        int count = getBaseDao().updateProcessNo(processNo, scanTypeName, taskLoopCount, new Date());
        LOGGER.debug("count: {}", count);
        return count;
    }

    @Override
    @Transactional
    public int updateNextTask(Long id) {
        int count = getBaseDao().updateNextTask(id);
        LOGGER.debug("count: {}", count);
        return count;
    }
}
