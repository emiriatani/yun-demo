package com.myf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName com.myf.demo.dto TeamDTO
 * @Description
 * @Author Afengis
 * @Date 2021/4/23 15:34
 * @Version V1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO  implements Serializable {
    private static final long serialVersionUID = -4687797586842047093L;

    /**
     * 主键列
     */
    private Long id;


    /*
    团队名
     */
    private String name;

    /**
     * 团队长id
     */
    private Long teamLeader;


    /*
       团队长姓名
     */
    private String teamLeaderName;


    /**
     * 管辖区域id
     */
    private Long regionId;

    /*
    管辖区域名称
     */
    private String  regionName;

    /**
     * 团队人数
     */
    private Long total;

    /**
     * 团队状态 0无效1有效
     */
    private Byte state;

    private String stateName;

    /**
     * 创建时间
     */
    private String createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Long teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTeamLeaderName() {
        return teamLeaderName;
    }

    public void setTeamLeaderName(String teamLeaderName) {
        this.teamLeaderName = teamLeaderName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName() {
        if (this.getState() == 0){
            this.stateName = "否";
        }else if (this.getState() == 1){
            this.stateName = "是";
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
}
