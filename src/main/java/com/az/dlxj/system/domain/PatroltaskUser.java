package com.az.dlxj.system.domain;

/**
 * PatroltaskUser entity. @author MyEclipse Persistence Tools
 */

public class PatroltaskUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pid;
	private Integer uid;

	// Constructors

	/** default constructor */
	public PatroltaskUser() {
	}

	/** full constructor */
	public PatroltaskUser(String pid, Integer uid) {
		this.pid = pid;
		this.uid = uid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}