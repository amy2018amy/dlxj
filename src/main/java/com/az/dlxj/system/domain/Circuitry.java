package com.az.dlxj.system.domain;


import java.util.List;

/**
 * Circuitry entity. @author MyEclipse Persistence Tools
 */

public class Circuitry  implements java.io.Serializable {


    // Fields    

     private String id;
     private Pole poleByEndpoleNo;
     private Pole poleByStartpoleNo;
     private String name;
     private String length;
     private String arroundlength;
     private Integer towercount;
     private Integer voltage;
     private Integer state;
     private String remark;
     private List<CircuitryPole> allPole;

    // Constructors

    /** default constructor */
    public Circuitry() {
    }

	/** minimal constructor */
    public Circuitry(String name, Integer towercount, Integer voltage, Integer state) {
        this.name = name;
        this.towercount = towercount;
        this.voltage = voltage;
        this.state = state;
    }
    
    /** full constructor */
    public Circuitry(Pole poleByEndpoleNo, Pole poleByStartpoleNo, String name, String length, String arroundlength, Integer towercount, Integer voltage, Integer state, String remark) {
        this.poleByEndpoleNo = poleByEndpoleNo;
        this.poleByStartpoleNo = poleByStartpoleNo;
        this.name = name;
        this.length = length;
        this.arroundlength = arroundlength;
        this.towercount = towercount;
        this.voltage = voltage;
        this.state = state;
        this.remark = remark;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public Pole getPoleByEndpoleNo() {
        return this.poleByEndpoleNo;
    }
    
    public void setPoleByEndpoleNo(Pole poleByEndpoleNo) {
        this.poleByEndpoleNo = poleByEndpoleNo;
    }

    public Pole getPoleByStartpoleNo() {
        return this.poleByStartpoleNo;
    }
    
    public void setPoleByStartpoleNo(Pole poleByStartpoleNo) {
        this.poleByStartpoleNo = poleByStartpoleNo;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return this.length;
    }
    
    public void setLength(String length) {
        this.length = length;
    }

    public String getArroundlength() {
        return this.arroundlength;
    }
    
    public void setArroundlength(String arroundlength) {
        this.arroundlength = arroundlength;
    }

    public Integer getTowercount() {
        return this.towercount;
    }
    
    public void setTowercount(Integer towercount) {
        this.towercount = towercount;
    }

    public Integer getVoltage() {
        return this.voltage;
    }
    
    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getState() {
        return this.state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }


    public List<CircuitryPole> getAllPole() {
        return allPole;
    }

    public void setAllPole(List<CircuitryPole> allPole) {
        this.allPole = allPole;
    }
}