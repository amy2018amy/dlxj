package com.az.dlxj.system.domain;

import java.util.Date;

/**
 * LoginLog entity. @author MyEclipse Persistence Tools
 */

public class LoginLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private Date time;
	private String ip;

	// Constructors

	/** default constructor */
	public LoginLog() {
	}

	/** full constructor */
	public LoginLog(Integer uid, Date time,String ip) {
		this.uid = uid;
		this.time = time;
		this.ip=ip;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	

}