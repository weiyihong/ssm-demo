package org.layz.hx.web.job;

import org.layz.hx.core.config.JobTemplate;
import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ErpJobkConfig extends JobTemplate<ErpJobEntity> {
    private static final String cron = "0/20 * * * * ?";
    @PostConstruct
    public void init(){
        setScanTypeName("erpTask");
        setSingleThread(true);
        setTaskLoopCount(10);
    }

    @Override
    public String cron() {
        return cron;
    }
}
