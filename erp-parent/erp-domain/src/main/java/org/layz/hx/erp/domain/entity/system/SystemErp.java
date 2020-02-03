package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

import java.util.List;

@HxTable("sys_system")
public class SystemErp extends AutoLongBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2806013590109891679L;
	@HxColumn(sort = 1)
	private String sysCode;
	@HxColumn(sort = 2)
	private String sysName;
	@HxColumn(sort = 3)
	private String remark;
	private List<Role> roleList;

	public String getSysCode() {
		return sysCode;
	}
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
