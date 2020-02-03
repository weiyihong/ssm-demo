package org.layz.hx.web.wrapper.system;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.layz.hx.core.annotation.HxValid;
import org.layz.hx.core.util.Assert;
import org.layz.hx.erp.domain.delegate.system.SystemErpDelegate;
import org.layz.hx.erp.domain.delegate.system.UserDelegate;
import org.layz.hx.erp.domain.entity.common.vo.NodeVo;
import org.layz.hx.erp.domain.entity.system.Role;
import org.layz.hx.erp.domain.entity.system.SystemErp;
import org.layz.hx.erp.domain.entity.system.User;
import org.layz.hx.erp.domain.entity.system.dto.LoginDto;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;
import org.layz.hx.erp.domain.enums.common.ErpSessionEnum;
import org.layz.hx.erp.domain.enums.response.ErpSystemEnum;
import org.layz.hx.spring.mvc.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserWrapperImpl implements UserWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserWrapperImpl.class);
    @Autowired
    private UserDelegate userDelegate;
    @Autowired
    private SystemErpDelegate systemErpDelegate;
    @Override
    @HxValid
    public LoginVo login(LoginDto loginDto) {
        LOGGER.debug("userCode: {}", loginDto.getUserCode());
        User user = userDelegate.login(loginDto.getUserCode(),loginDto.getPassWord());

        Assert.isNotNull(user,ErpSystemEnum.LOGIN_INPUT_ERROR);
        Role defaultRole = user.getDefaultRole();
        Assert.isNotNull(defaultRole,ErpSystemEnum.USER_ROLE_EMPTY);

        LoginVo loginVo = new LoginVo();
        loginVo.setUserId(user.getId());
        loginVo.setUserName(user.getUserName());
        loginVo.setRoleId(defaultRole.getId());
        loginVo.setSysId(defaultRole.getSysId());
        RequestUtil.setSessionAttribute(ErpSessionEnum.LOGIN_INFO, loginVo);

        return loginVo;
    }

    @Override
    public List<NodeVo> querRole(Long userId) {
        LOGGER.debug("userId: {}",userId);
        List<SystemErp> list = systemErpDelegate.queryUserAuth(userId);
        Assert.isNotEmpty(list,ErpSystemEnum.USER_ROLE_EMPTY);
        List<NodeVo> nodeVoList = list.stream().map(o -> {
            NodeVo nodeVo = new NodeVo();
            nodeVo.setCode(o.getId().toString());
            nodeVo.setValue(o.getSysName());
            nodeVo.setChildren(obtainRole(o.getRoleList()));
            return nodeVo;
        }).collect(Collectors.toList());
        return nodeVoList;
    }

    /**
     * @param roleList
     * @return
     */
    private List<NodeVo> obtainRole(List<Role> roleList) {
        Assert.isNotEmpty(roleList,ErpSystemEnum.USER_ROLE_EMPTY);
        List<NodeVo> list = roleList.stream().map(o -> {
            NodeVo nodeVo = new NodeVo();
            nodeVo.setCode(o.getId().toString());
            nodeVo.setValue(o.getRoleName());
            return nodeVo;
        }).collect(Collectors.toList());
        return list;
    }
}
