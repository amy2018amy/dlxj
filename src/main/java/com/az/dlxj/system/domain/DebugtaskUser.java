package com.az.dlxj.system.domain;

/**
 * DebugtaskUser entity. @author MyEclipse Persistence Tools
 */

public class DebugtaskUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String did;
	private Integer uid;

	// Constructors

	/** default constructor */
	public DebugtaskUser() {
	}

	/** full constructor */
	public DebugtaskUser(String did, Integer uid) {
		this.did = did;
		this.uid = uid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDid() {
		return this.did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}