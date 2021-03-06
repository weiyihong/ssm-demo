package org.layz.hx.spring.jdbc.service;

import org.layz.hx.core.entity.BaseJobEntity;

public interface BaseJobService<T extends BaseJobEntity> extends BaseService<T> {
    /**
     * 1: 扫描类为 scanTypeName
     * 2：开始执行时间小于当前时间
     * 3：执行状态为 JobStatusEnum.WAITE_HANDLE
     *    or JobStatusEnum.HANDLE_FAIL and failCount <= 5
     * @param scanTypeName
     * @return
     */
    int findCountByName(String scanTypeName);

    /**
     * 更新批次号
     * @param processNo
     * @param scanTypeName
     * @param taskLoopCount
     */
    int updateProcessNo(String processNo, String scanTypeName, Integer taskLoopCount);

    /**
     * 更新下一个批次号
     * @param id
     */
    int updateNextTask(Long id);
}
