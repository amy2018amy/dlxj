package com.az.dlxj.system.domain;

import java.util.Date;
import java.util.List;

/**
 * Patroltask entity. @author MyEclipse Persistence Tools
 */

public class Patroltask implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String cid;
	private String startPoleNo;
	private String endPoleNo;
	private Integer uid;
	private Date time;
	private String state;
	private Integer cancel;
	private Date endTime;
	private List<Pole> polies;
	private String userName;

	// Constructors

	/** default constructor */
	public Patroltask() {
	}

	/** minimal constructor */
	public Patroltask(String name, String cid, String startPoleNo,
			String endPoleNo, Integer uid, Date time, String state,
			Integer cancel) {
		this.name = name;
		this.cid = cid;
		this.startPoleNo = startPoleNo;
		this.endPoleNo = endPoleNo;
		this.uid = uid;
		this.time = time;
		this.state = state;
		this.cancel = cancel;
	}

	/** full constructor */
	public Patroltask(String name, String cid, String startPoleNo,
			String endPoleNo, Integer uid, Date time, String state,
			Integer cancel, Date endTime) {
		this.name = name;
		this.cid = cid;
		this.startPoleNo = startPoleNo;
		this.endPoleNo = endPoleNo;
		this.uid = uid;
		this.time = time;
		this.state = state;
		this.cancel = cancel;
		this.endTime = endTime;
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

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getStartPoleNo() {
		return this.startPoleNo;
	}

	public void setStartPoleNo(String startPoleNo) {
		this.startPoleNo = startPoleNo;
	}

	public String getEndPoleNo() {
		return this.endPoleNo;
	}

	public void setEndPoleNo(String endPoleNo) {
		this.endPoleNo = endPoleNo;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getCancel() {
		return this.cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<Pole> getPolies() {
		return polies;
	}

	public void setPolies(List<Pole> polies) {
		this.polies = polies;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}