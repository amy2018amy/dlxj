package com.az.dlxj.system.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * Purview entity. @author MyEclipse Persistence Tools
 */

public class Purview  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String mid;
     private Set users = new HashSet(0);
     private Set groups = new HashSet(0);


    // Constructors

    /** default constructor */
    public Purview() {
    }

	/** minimal constructor */
    public Purview(String mid) {
        this.mid = mid;
    }
    
    /** full constructor */
    public Purview(String mid, Set users, Set groups) {
        this.mid = mid;
        this.users = users;
        this.groups = groups;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMid() {
        return this.mid;
    }
    
    public void setMid(String mid) {
        this.mid = mid;
    }

    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }

    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }
   








}