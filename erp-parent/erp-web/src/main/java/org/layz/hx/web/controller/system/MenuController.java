package org.layz.hx.web.controller.system;

import org.layz.hx.core.enums.SessionEnum;
import org.layz.hx.core.pojo.response.JsonResponse;
import org.layz.hx.core.util.ResponseUtil;
import org.layz.hx.erp.domain.entity.system.Menu;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.layz.hx.web.wrapper.system.MenuWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system/menu")
public class MenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuWrapper menuWrapper;
    /**
     * 菜单信息查询
     * @return
     */
    @GetMapping("/roleMenu")
    public JsonResponse queryRoleMenu(){
        LoginVo loginVo = (LoginVo) RequestUtil.getSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        LOGGER.debug("roleId: {}", loginVo.getRoleId());
        Menu menu = menuWrapper.queryRoleMenu(loginVo.getRoleId());
        return ResponseUtil.getObjectResponse(menu);
    }
}
