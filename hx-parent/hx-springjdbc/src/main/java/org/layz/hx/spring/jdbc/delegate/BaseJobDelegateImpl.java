package org.layz.hx.spring.jdbc.delegate;

import org.layz.hx.core.delegate.BaseJobDelegate;
import org.layz.hx.core.entity.BaseJobEntity;
import org.layz.hx.spring.jdbc.service.BaseJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class BaseJobDelegateImpl<T extends BaseJobEntity> implements BaseJobDelegate<T> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseJobDelegateImpl.class);
    public abstract BaseJobService<T> getService();

    public abstract T getInstance();

    @Override
    public int findCountByName(String scanTypeName) {
        LOGGER.debug("scanTypeName: {}", scanTypeName);
        return getService().findCountByName(scanTypeName);
    }

    @Override
    public int updateProcessNo(String processNo, String scanTypeName, Integer taskLoopCount) {
        LOGGER.debug("scanTypeName: {},taskLoopCount: {},processNo: {}", scanTypeName, taskLoopCount, processNo);
        return getService().updateProcessNo(processNo,scanTypeName,taskLoopCount);
    }

    @Override
    public List<T> findByProcessNo(String processNo) {
        LOGGER.debug("processNo: {}", processNo);
        T erpJobEntity = getInstance();
        erpJobEntity.setProcessNo(processNo);
        return getService().findByEntity(erpJobEntity);
    }

    @Override
    public void updateBatch(List<T> list) {
        if(null == list || list.isEmpty()) {
            return;
        }
        LOGGER.debug("size: {}", list.size());
        for (T entity : list) {
            getService().update(entity);
        }
    }

    @Override
    public void updateNextTask(List<Long> nextTaskList) {
        if(null == nextTaskList || nextTaskList.isEmpty()) {
            return;
        }
        LOGGER.debug("size: {}", nextTaskList.size());
        for (Long id : nextTaskList) {
            if(null == id) {
                continue;
            }
            getService().updateNextTask(id);
        }
    }
}
