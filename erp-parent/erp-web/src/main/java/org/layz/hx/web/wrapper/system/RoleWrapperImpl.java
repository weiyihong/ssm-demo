package org.layz.hx.web.wrapper.system;

import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.delegate.system.RoleDelegate;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleWrapperImpl implements RoleWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleWrapperImpl.class);
    @Autowired
    private RoleDelegate roleDelegate;
    @Override
    public LoginVo change(Long roleId) {
        LOGGER.debug("roleId: {}", roleId);
        LoginVo loginVo = (LoginVo) RequestUtil.getSessionAttribute(ErpSessionEnum.LOGIN_INFO);
        Assert.isFalse(roleId.equals(loginVo.getRoleId()), ErpSystemEnum.ROLE_NO_CHANGE);
        Role role = roleDelegate.changeRole(loginVo.getUserId(), roleId);
        Assert.isNotNull(role,ErpSystemEnum.ROLE_IS_ERROR);
        loginVo.setRoleId(roleId);
        loginVo.setSysId(role.getSysId());
        RequestUtil.setSessionAttribute(ErpSessionEnum.LOGIN_INFO,loginVo);
        return loginVo;
    }
}
