package org.layz.hx.web.controller.system;

import org.layz.hx.core.pojo.response.JsonResponse;
import org.layz.hx.core.util.Assert;
import org.layz.hx.core.util.ResponseUtil;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.web.wrapper.system.RoleWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system/role")
public class RoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleWrapper roleWrapper;
    /**
     * 角色切换
     * @param roleId
     * @return
     */
    @GetMapping("/change/{roleId}")
    public JsonResponse change(@PathVariable Long roleId){
        Assert.isNotNull(roleId, ErpSystemEnum.ROLE_ID_ISNULL);
        LOGGER.debug("roleId: {}", roleId);
        LoginVo loginVo = roleWrapper.change(roleId);
        return ResponseUtil.getObjectResponse(loginVo);
    }
}
