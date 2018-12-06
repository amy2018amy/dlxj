package com.az.dlxj.system.domain;

import java.util.Date;
import java.util.List;


/**
 * Debugtask entity. @author MyEclipse Persistence Tools
 */

public class Debugtask implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String type;
	private Integer principal;
	private Integer createUser;
	private Date time;
	private String description;
	private String remark;
	private Date endTime;
	private String state;
	private List<Receiptpatrol> receiptpatrols;
	private Receiptdebug receiptdebug;
	private String userName;
	// Constructors

	/** default constructor */
	public Debugtask() {
	}

	/** minimal constructor */
	public Debugtask(String name, String type, Integer principal,
			Integer createUser, Date time, String description, String state) {
		this.name = name;
		this.type = type;
		this.principal = principal;
		this.createUser = createUser;
		this.time = time;
		this.description = description;
		this.state = state;
	}

	/** full constructor */
	public Debugtask(String name, String type, Integer principal,
			Integer createUser, Date time, String description, String remark,
			Date endTime, String state) {
		this.name = name;
		this.type = type;
		this.principal = principal;
		this.createUser = createUser;
		this.time = time;
		this.description = description;
		this.remark = remark;
		this.endTime = endTime;
		this.state = state;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Integer principal) {
		this.principal = principal;
	}

	public Integer getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Receiptpatrol> getReceiptpatrols() {
		return receiptpatrols;
	}

	public void setReceiptpatrols(List<Receiptpatrol> receiptpatrols) {
		this.receiptpatrols = receiptpatrols;
	}

	public Receiptdebug getReceiptdebug() {
		return receiptdebug;
	}

	public void setReceiptdebug(Receiptdebug receiptdebug) {
		this.receiptdebug = receiptdebug;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




}