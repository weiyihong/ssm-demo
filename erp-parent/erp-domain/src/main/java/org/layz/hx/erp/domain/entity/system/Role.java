package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

@HxTable(value = "sys_role")
public class Role extends AutoLongBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1908676822748416957L;
	@HxColumn(sort = 1)
	private Long sysId;
	@HxColumn(sort = 2)
	private String roleCode;
	@HxColumn(sort = 3)
	private String roleName;
	@HxColumn(sort = 4)
	private Integer roleType;
	@HxColumn(sort = 5)
	private String remark;
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleType() {
		return roleType;
	}
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
