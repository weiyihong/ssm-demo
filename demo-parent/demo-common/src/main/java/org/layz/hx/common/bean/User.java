package org.layz.hx.common.bean;

public class User {
	private Long userId;
	private String userName;
	private String sex;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", sex=" + sex + "]";
	}
}
