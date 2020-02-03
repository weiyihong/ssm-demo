package org.layz.hx.erp.service.system;

import org.junit.Test;
import org.layz.hx.core.enums.type.DisableEnum;
import org.layz.hx.erp.BaseJunitTest;
import org.layz.hx.erp.domain.entity.system.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceTest extends BaseJunitTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceTest.class);
    @Autowired
    private RoleService roleService;
    @Test
    public void test(){
        List<Role> list = roleService.queryUserRole(1L, DisableEnum.ENABLE);
        LOGGER.debug("size: {}", list.size());
    }
}
