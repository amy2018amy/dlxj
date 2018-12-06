package com.az.dlxj.system.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Group entity. @author MyEclipse Persistence Tools
 */

public class Group  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Purview purview;
     private User _user;
     private String name;
     private Integer state;
     private Date createTime;
     private int userCount;
     private Set users = new HashSet(0);


    // Constructors

    /** default constructor */
    public Group() {
    }

	/** minimal constructor */
    public Group(Purview purview, User _user, String name, Integer state, Date createTime) {
        this.purview = purview;
        this._user = _user;
        this.name = name;
        this.state = state;
        this.createTime = createTime;
    }
    
    /** full constructor */
    public Group(Purview purview, User _user, String name, Integer state, Date createTime, Set users) {
        this.purview = purview;
        this._user = _user;
        this.name = name;
        this.state = state;
        this.createTime = createTime;
        this.users = users;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Purview getPurview() {
        return this.purview;
    }
    
    public void setPurview(Purview purview) {
        this.purview = purview;
    }

    

    public User get_user() {
		return _user;
	}

	public void set_user(User _user) {
		this._user = _user;
	}

	public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
   








}