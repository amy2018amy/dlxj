package com.az.dlxj.system.shiro.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDO implements Serializable{
	
	private Integer id;
	private String userName;
	private String password;
	// 加密密码的盐
	private String salt;
	// 用户状态：0：创建未认证，1：正常，2：用户被锁定
	private byte state;
	// 拥有的角色
	private Set<RoleDO> roles = new HashSet<>();

	@Override
	public String toString() {
		return "UserDO{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", state=" + state +
				", roles=" + roles +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public Set<RoleDO> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDO> roles) {
		this.roles = roles;
	}
}
