package com.az.dlxj.system.domain;

public class UserGroup {
	private String gname;
	private int gcount;
	
	
	
	public UserGroup() {
		super();
	}
	public UserGroup(String gname, int gcount) {
		super();
		this.gname = gname;
		this.gcount = gcount;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGcount() {
		return gcount;
	}
	public void setGcount(int gcount) {
		this.gcount = gcount;
	}
	

}
