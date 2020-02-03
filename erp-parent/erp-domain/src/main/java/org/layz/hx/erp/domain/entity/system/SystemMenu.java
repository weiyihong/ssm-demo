package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

@HxTable("sys_system_menu")
public class SystemMenu extends AutoLongBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1091083131387094580L;
	@HxColumn(sort = 1)
	private Long sysId;
	@HxColumn(sort = 2)
	private Long menuId;
	
	public Long getSysId() {
		return sysId;
	}
	
	public Long getMenuId() {
		return menuId;
	}
	
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}
