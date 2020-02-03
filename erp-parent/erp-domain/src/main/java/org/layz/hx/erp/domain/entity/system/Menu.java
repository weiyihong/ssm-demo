package org.layz.hx.erp.domain.entity.system;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxTable;
import org.layz.hx.core.entity.AutoLongBaseEntity;

import java.util.List;

@HxTable("sys_menu")
public class Menu extends AutoLongBaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8104190755819299633L;
	@HxColumn(value = "parentId",sort = 1)
	private Long parentId;
	@HxColumn(value = "menuCode",sort = 2)
	private String code;
	@HxColumn(value = "menuName",sort = 3)
	private String name;
	@HxColumn(value = "menuType",sort = 4)
	private Integer type;
	@HxColumn(value = "menuSort",sort = 5)
	private Integer sort;
	@HxColumn(value = "menuIcon",sort = 6)
	private String icon;
	@HxColumn(value = "remark",sort = 7)
	private String remark;
	@HxColumn(value = "menuUrl",sort = 8)
	private String url;
	@HxColumn(value = "helpUrl",sort = 9)
	private String helpUrl;
	private List<Menu> children;
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHelpUrl() {
		return helpUrl;
	}
	public void setHelpUrl(String helpUrl) {
		this.helpUrl = helpUrl;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}
