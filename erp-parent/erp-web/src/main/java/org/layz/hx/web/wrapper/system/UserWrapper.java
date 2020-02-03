package org.layz.hx.web.wrapper.system;

import org.layz.hx.erp.domain.entity.common.vo.NodeVo;
import org.layz.hx.erp.domain.entity.system.dto.LoginDto;
import org.layz.hx.erp.domain.entity.system.vo.LoginVo;

import java.util.List;

public interface UserWrapper {
    /**
     * 登录
     * @param loginDto
     * @return
     */
    LoginVo login(LoginDto loginDto);

    /**
     * 角色查询
     * @param userId
     * @return
     */
    List<NodeVo> querRole(Long userId);
}
