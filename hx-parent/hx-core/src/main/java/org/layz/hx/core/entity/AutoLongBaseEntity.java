package org.layz.hx.core.entity;

import org.layz.hx.core.annotation.HxColumn;
import org.layz.hx.core.annotation.HxSupperClass;

@HxSupperClass
public class AutoLongBaseEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2641209235577591499L;
	@HxColumn
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
