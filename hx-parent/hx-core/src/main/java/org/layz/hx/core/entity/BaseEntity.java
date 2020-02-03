package org.layz.hx.core.entity;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxSupperClass;

import java.io.Serializable;
import java.util.Date;

@HxSupperClass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053568662236406287L;
	@HxColumn(sort = 101)
	private Integer deleted;
	@HxColumn(sort = 102)
	private Long createdBy;
	@HxColumn(sort = 103)
	private Long lastModifiedBy;
	@HxColumn(sort = 104)
	private Date createdDate;
	@HxColumn(sort = 105)
	private Date lastModifiedDate;
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
