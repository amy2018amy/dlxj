package com.az.dlxj.system.domain;



/**
 * Model entity. @author MyEclipse Persistence Tools
 */

public class Model  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer pid;
     private String url;
     private Integer state;


    // Constructors

    /** default constructor */
    public Model() {
    }

    
    /** full constructor */
    public Model(String name, Integer pid, String url, Integer state) {
        this.name = name;
        this.pid = pid;
        this.url = url;
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

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
   








}