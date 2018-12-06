package com.az.dlxj.system.domain;



/**
 * Bugtype entity. @author MyEclipse Persistence Tools
 */

public class Bugtype  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer state;


    // Constructors

    /** default constructor */
    public Bugtype() {
    }

    
    /** full constructor */
    public Bugtype(String name, Integer state) {
        this.name = name;
        this.state = state;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
   








}