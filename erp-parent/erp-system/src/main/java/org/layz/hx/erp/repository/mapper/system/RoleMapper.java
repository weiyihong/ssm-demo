package org.layz.hx.erp.repository.mapper.system;

import org.apache.ibatis.annotations.Param;
import org.layz.hx.erp.domain.entity.system.Role;

import java.util.List;

public interface RoleMapper {
    /**
     * @param userId
     * @param disable
     * @return
     */
    List<Role> queryUserRole(@Param("userId") Long userId, @Param("disable") Integer disable);
}
