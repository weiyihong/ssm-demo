package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

@HxTable("sys_dic")
public class Dictional extends AutoLongBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091317816932300054L;
	@HxColumn(value = "sysId", sort = 1)
	private Long sysId;
	@HxColumn(value = "dicCode", sort = 2)
	private String code;
	@HxColumn(value = "parentCode", sort = 3)
	private String parentCode;
	@HxColumn(value = "dicKey", sort = 4)
	private String key;
	@HxColumn(value = "dicValue", sort = 5)
	private String value;
	@HxColumn(value = "dicSort", sort = 6)
	private Integer sort;
	@HxColumn(value = "dicType", sort = 7)
	private Integer type;
	@HxColumn(value = "remark", sort = 8)
	private String remark;
	public Long getSysId() {
		return sysId;
	}
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
