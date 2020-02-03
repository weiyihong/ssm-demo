package org.layz.hx.core.service;

import org.layz.hx.core.entity.BaseJobEntity;

public abstract class JobService<T extends BaseJobEntity> implements JobExcuteHandler<T>{
    @Override
    public void onBefore(T entity) {

    }

    @Override
    public void onAfter() {

    }
}
