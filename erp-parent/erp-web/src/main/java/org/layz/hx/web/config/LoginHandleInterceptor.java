package org.layz.hx.web.config;

import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandleInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginVo loginVo = (LoginVo) RequestUtil.getSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        Assert.isNotNull(loginVo, ErpSystemEnum.NOY_LOGIN_ERROR);
        return true;
    }
}
