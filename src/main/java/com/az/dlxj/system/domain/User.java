package com.az.dlxj.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements Serializable {
    private static final long serialVersionUID = -1373760761780840081L;

    // 角色
    private Integer rid;
    // 昵称
    private String nickName;
    // 头像
    private String icon;
    // 用户状态：0：创建未认证，1：正常，2：用户被锁定
    private Integer state;
    // 加密密码的盐
    private String salt;
    // Fields

     private Integer id;
     private Purview purview;
     private Group group;
     private String username;
     private String name;
     private String password;
     private String sex;
     private Integer age;
     private Date joindate;
     private Date leavedate;
     private String phone;
     private String email;
     private String remark;
     private String lastLoginDate;
     private String lastLoginIp;
     private Integer waitCount;
     private Set groups = new HashSet(0);


    // Constructors
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(Group group, String username, String name, String password, String sex, Integer age, Date joindate, Integer state) {
        this.group = group;
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.joindate = joindate;
        this.state = state;
    }
    
    /** full constructor */
    public User(Purview purview, Group group, String username, String name, String password, String sex, Integer age, Date joindate, Date leavedate, String phone, String email, Integer state, String remark, Set groups) {
        this.purview = purview;
        this.group = group;
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.joindate = joindate;
        this.leavedate = leavedate;
        this.phone = phone;
        this.email = email;
        this.state = state;
        this.remark = remark;
        this.groups = groups;
    }

   
    // Property accessors

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

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

    public Group getGroup() {
        return this.group;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getJoindate() {
        return this.joindate;
    }
    
    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Date getLeavedate() {
        return this.leavedate;
    }
    
    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
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

    public Set getGroups() {
        return this.groups;
    }
    
    public void setGroups(Set groups) {
        this.groups = groups;
    }

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getWaitCount() {
		return waitCount;
	}

	public void setWaitCount(Integer waitCount) {
		this.waitCount = waitCount;
	}
   








}