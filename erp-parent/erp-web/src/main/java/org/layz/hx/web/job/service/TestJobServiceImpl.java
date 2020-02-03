package org.layz.hx.web.job.service;

import org.layz.hx.core.pojo.response.JsonResponse;
import org.layz.hx.core.service.JobService;
import org.layz.hx.core.util.ResponseUtil;
import org.layz.hx.erp.domain.entity.system.ErpJobEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestJobServiceImpl extends JobService<ErpJobEntity> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestJobServiceImpl.class);

    @Override
    public JsonResponse doTask(ErpJobEntity entity) {
        LOGGER.debug("\n\n\n");
        return ResponseUtil.getSuccessResponse();
    }

}
