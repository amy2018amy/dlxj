package com.az.dlxj.system.domain;

/**
 * CircuitryPole entity. @author MyEclipse Persistence Tools
 */

public class CircuitryPole implements java.io.Serializable {

	// Fields

	private Integer id;
	private String pid;
	private String cid;
	private Integer position;
	private Pole pole;

	// Constructors

	/** default constructor */
	public CircuitryPole() {
	}

	/** full constructor */
	public CircuitryPole(String pid, String cid, Integer position) {
		this.pid = pid;
		this.cid = cid;
		this.position = position;
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

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Pole getPole() {
		return pole;
	}

	public void setPole(Pole pole) {
		this.pole = pole;
	}
}