package com.az.dlxj.system.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Pole entity. @author MyEclipse Persistence Tools
 */

public class Pole implements java.io.Serializable {

	// Fields

	private String id;
	private Double lng;
	private Double lat;
	private Integer state;
	private String routeName;
	private Receiptpatrol receiptpatrol;
	private boolean isReceipt;
	private Set circuitriesForStartpoleNo = new HashSet(0);
	private Set circuitriesForEndpoleNo = new HashSet(0);

	// Constructors

	/** default constructor */
	public Pole() {
	}

	/** minimal constructor */
	public Pole(Double lng, Double lat, Integer state) {
		this.lng = lng;
		this.lat = lat;
		this.state = state;
	}

	/** full constructor */
	public Pole(Double lng, Double lat, Integer state,
			Set circuitriesForStartpoleNo, Set circuitriesForEndpoleNo) {
		this.lng = lng;
		this.lat = lat;
		this.state = state;
		this.circuitriesForStartpoleNo = circuitriesForStartpoleNo;
		this.circuitriesForEndpoleNo = circuitriesForEndpoleNo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getLng() {
		return this.lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return this.lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getCircuitriesForStartpoleNo() {
		return this.circuitriesForStartpoleNo;
	}

	public void setCircuitriesForStartpoleNo(Set circuitriesForStartpoleNo) {
		this.circuitriesForStartpoleNo = circuitriesForStartpoleNo;
	}

	public Set getCircuitriesForEndpoleNo() {
		return this.circuitriesForEndpoleNo;
	}

	public void setCircuitriesForEndpoleNo(Set circuitriesForEndpoleNo) {
		this.circuitriesForEndpoleNo = circuitriesForEndpoleNo;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Receiptpatrol getReceiptpatrol() {
		return receiptpatrol;
	}

	public void setReceiptpatrol(Receiptpatrol receiptpatrol) {
		this.receiptpatrol = receiptpatrol;
	}

	public boolean isReceipt() {
		return isReceipt;
	}

	public void setReceipt(boolean isReceipt) {
		this.isReceipt = isReceipt;
	}
	
	

}