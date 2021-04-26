package com.myf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName com.myf.demo.dto DoctorDTO
 * @Description
 * @Author Afengis
 * @Date 2021/4/26 15:06
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO implements Serializable {

    private static final long serialVersionUID = 9197871658284120474L;

    /**
     * 主键列
     */
    private Long id;

    /**
     * 所属团队id
     */
    private Long teamId;

    /**
     * 所属团队名
     */
    private String teamName;
    /**
     * 所属账号id
     */
    private Long userId;

    /**
     * 所属账号名
     */
    private String userName;

    /**
     * 医生姓名
     */
    private String name;

    /**
     * 医生信息状态 0无效1有效
     */
    private Long state;

    /**
     * 状态名
     */
    private String stateName;

    /**
     * 创建时间
     */
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName() {
        if (getState() == 0){
            this.stateName = "已失效";
        }else if (getState() == 1){
            this.stateName =  "有效";
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
        return "DoctorDTO{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", stateName='" + stateName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
