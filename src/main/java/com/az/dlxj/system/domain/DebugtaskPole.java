package com.az.dlxj.system.domain;

/**
 * DebugtaskPole entity. @author MyEclipse Persistence Tools
 */

public class DebugtaskPole implements java.io.Serializable {

	// Fields
	private Integer id;
	private String did;
	private String pid;
	private String ptid;

	// Constructors

	/** default constructor */
	public DebugtaskPole() {
	}

	/** full constructor */
	public DebugtaskPole(String did, String pid,String ptid) {
		this.did = did;
		this.pid = pid;
		this.ptid=ptid;
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

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPtid() {
		return ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

}