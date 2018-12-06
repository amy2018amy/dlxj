package com.az.dlxj.system.domain;

import java.util.Date;

/**
 * Receiptpatrol entity. @author MyEclipse Persistence Tools
 */

public class Receiptpatrol implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ptid;
	private String pid;
	private String routeName;
	private String userName;
	private Integer bid;
	private String typeName;
	private Integer level;
	private Integer intact;
	private Integer uid;
	private Date time;
	private String description;
	private Pole pole;
	private Patroltask patroltask;
	private String levelName;

	// Constructors

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/** default constructor */
	public Receiptpatrol() {
	}

	/** full constructor */
	public Receiptpatrol(String ptid, String pid, Integer bid, Integer level,
			Integer intact, Integer uid, Date time, String description) {
		this.ptid = ptid;
		this.pid = pid;
		this.bid = bid;
		this.level = level;
		this.intact = intact;
		this.uid = uid;
		this.time = time;
		this.description = description;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPtid() {
		return this.ptid;
	}

	public void setPtid(String ptid) {
		this.ptid = ptid;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIntact() {
		return this.intact;
	}

	public void setIntact(Integer intact) {
		this.intact = intact;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Patroltask getPatroltask() {
		return patroltask;
	}

	public void setPatroltask(Patroltask patroltask) {
		this.patroltask = patroltask;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	

}