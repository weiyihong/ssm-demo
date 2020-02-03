package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

@HxTable("sys_role_menu")
public class RoleMenu extends AutoLongBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6231513108070666990L;
	@HxColumn(sort = 1)
	private Long roleId;
	@HxColumn(sort = 2)
	private Long menuId;
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public Long getMenuId() {
		return menuId;
	}
	
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
