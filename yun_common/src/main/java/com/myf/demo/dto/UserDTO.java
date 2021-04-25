package com.myf.demo.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName com.myf.demo.dto UserDTO
 * @Description
 * @Author Afengis
 * @Date 2021/4/16 13:35
 * @Version V1.0
 **/

public class UserDTO implements Serializable {

    private static final long serialVersionUID = -7806460722668374928L;

    /*主键*/
    private Long id;
    /*用户名*/
    private String username;
    /*密码*/
    private String password;
    /*登录名*/
    private String loginName;
    /* 启用状态 0未启用 1启用 */
    private Byte status;
    /* 页面启用提示 */
    private String accountStatus;
    /*分配状态 0未分配 1已分配*/
    private Byte allocationStatus;
    /*页面分配提示*/
    private String allocationStatusTip;
    /*创建时间*/
    private String createTime;

    public UserDTO(){}

    public UserDTO(Long id, String username, String password, String loginName, Byte status, String accountStatus, Byte allocationStatus, String allocationStatusTip, String createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.loginName = loginName;
        this.status = status;
        this.accountStatus = accountStatus;
        this.allocationStatus = allocationStatus;
        this.allocationStatusTip = allocationStatusTip;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getAllocationStatus() {
        return allocationStatus;
    }
    public void setAllocationStatus(Byte allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus() {
        if (getStatus().intValue() == 0){
            this.accountStatus = "否";
        }else if (getStatus().intValue() == 1){
            this.accountStatus = "是";
        }
    }

    public String getAllocationStatusTip() {
        return allocationStatusTip;
    }

    public void setAllocationStatusTip() {
        if (getAllocationStatus().intValue() == 0){
            this.allocationStatusTip = "否";
        }else if (getAllocationStatus().intValue() == 1){
            this.allocationStatusTip = "是";
        }
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(createTime);
        this.createTime = format;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginName='" + loginName + '\'' +
                ", status=" + status +
                ", accountStatus='" + accountStatus + '\'' +
                ", allocationStatus=" + allocationStatus +
                ", allocationStatusTip='" + allocationStatusTip + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
