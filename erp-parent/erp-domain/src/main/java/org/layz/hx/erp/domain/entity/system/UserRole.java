package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

@HxTable("sys_user_role")
public class UserRole extends AutoLongBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@HxColumn(sort = 1)
	private Long userId;
	@HxColumn(sort = 2)
	private Long roleId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
}
