package org.layz.hx.web.config;

import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.layz.hx.web.wrapper.system.MenuWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AuthHandleInteceptor implements HandlerInterceptor {
    @Autowired
    private MenuWrapper menuWrapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginVo loginVo = (LoginVo) RequestUtil.getSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        String url = requestURI.replace(contextPath,"");
        List<String> list = menuWrapper.queryRolePath(loginVo.getRoleId());
        Assert.isNotEmpty(list,ErpSystemEnum.USER_ROLE_EMPTY);
        for (String path : list) {
            if(url.startsWith(path)) {
                return true;
            }
        }
        Assert.isFalse(true, ErpSystemEnum.USER_ROLE_EMPTY);
        return true;
    }
}
