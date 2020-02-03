package org.layz.hx.web.controller.system;

import org.layz.hx.core.pojo.response.JsonResponse;
import org.layz.hx.core.util.ResponseUtil;
import org.layz.hx.erp.domain.entity.common.vo.NodeVo;
import org.layz.hx.erp.domain.entity.system.dto.LoginDto;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.layz.hx.web.wrapper.system.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserWrapper userWrapper;
    /**
     * 登录
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public JsonResponse login(@RequestBody LoginDto loginDto){
        LOGGER.debug("userCode: {}", loginDto.getUserCode());
        LoginVo loginVo = userWrapper.login(loginDto);
        return ResponseUtil.getObjectResponse(loginVo);
    }

    /**
     * @return
     */
    @GetMapping("/logout")
    public JsonResponse logout(){
        LOGGER.debug("logout");
        RequestUtil.removeSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        return ResponseUtil.getSuccessResponse();
    }

    /**
     * 角色信息查询
     * @return
     */
    @GetMapping("/role")
    public JsonResponse queryRole(){
        LoginVo loginVo = (LoginVo) RequestUtil.getSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        LOGGER.debug("userId: {},userName: {}",loginVo.getUserId() , loginVo.getUserId());
        List<NodeVo> list = userWrapper.querRole(loginVo.getUserId());
        return ResponseUtil.getObjectResponse(list);
    }
}
