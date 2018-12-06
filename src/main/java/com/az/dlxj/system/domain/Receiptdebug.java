package com.az.dlxj.system.domain;

import java.util.Date;

/**
 * Receiptdebug entity. @author MyEclipse Persistence Tools
 */

public class Receiptdebug implements java.io.Serializable {

	// Fields

	private Integer id;
	private String did;
	private String description;
	private String idea;
	private Integer state;
	private String defer;
	private String bulletin;
	private Date time;
	private Integer uid;

	// Constructors

	/** default constructor */
	public Receiptdebug() {
	}

	/** minimal constructor */
	public Receiptdebug(String did, String description, Integer state, Date time,Integer uid) {
		this.did = did;
		this.description = description;
		this.state = state;
		this.time = time;
		this.uid = uid;
	}

	/** full constructor */
	public Receiptdebug(String did, String description, String idea,
			Integer state, String defer, String bulletin, Date time,Integer uid) {
		this.did = did;
		this.description = description;
		this.idea = idea;
		this.state = state;
		this.defer = defer;
		this.bulletin = bulletin;
		this.time = time;
		this.uid= uid;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdea() {
		return this.idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDefer() {
		return this.defer;
	}

	public void setDefer(String defer) {
		this.defer = defer;
	}

	public String getBulletin() {
		return this.bulletin;
	}

	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

}