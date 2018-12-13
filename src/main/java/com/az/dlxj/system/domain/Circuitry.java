package com.az.dlxj.system.domain;


import java.util.List;

/**
 * Circuitry entity. @author MyEclipse Persistence Tools
 */

public class Circuitry  implements java.io.Serializable {


    // Fields    
//"id":"1234",
// "name":"234",
// "voltage":"234",
// "startNo":"100011",
// "endNo":"10013",
// "jihe":"10012 ",
// "arroundlength":"136公里",
// "towercount":"3"
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
     private Integer startNo;
     private Integer endNo;
     private String jihe;

    public String getJihe() {
        return jihe;
    }

    public void setJihe(String jihe) {
        this.jihe = jihe;
    }

    public Integer getStartNo() {
        return startNo;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }

    public Integer getEndNo() {
        return endNo;
    }

    public void setEndNo(Integer endNo) {
        this.endNo = endNo;
    }
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pole getPoleByEndpoleNo() {
        return poleByEndpoleNo;
    }

    public void setPoleByEndpoleNo(Pole poleByEndpoleNo) {
        this.poleByEndpoleNo = poleByEndpoleNo;
    }

    public Pole getPoleByStartpoleNo() {
        return poleByStartpoleNo;
    }

    public void setPoleByStartpoleNo(Pole poleByStartpoleNo) {
        this.poleByStartpoleNo = poleByStartpoleNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getArroundlength() {
        return arroundlength;
    }

    public void setArroundlength(String arroundlength) {
        this.arroundlength = arroundlength;
    }

    public Integer getTowercount() {
        return towercount;
    }

    public void setTowercount(Integer towercount) {
        this.towercount = towercount;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
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