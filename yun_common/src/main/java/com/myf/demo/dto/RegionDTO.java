package com.myf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName com.myf.demo.dto RegionDTO
 * @Description
 * @Author Afengis
 * @Date 2021/4/27 15:06
 * @Version V1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public class RegionDTO  implements Serializable {
    private static final long serialVersionUID = -3067574171957004009L;

    /**
     * 主键列
     */
    private Long id;

    /**
     * 详细地址，如某某社区、某某街道
     */
    private String  address;

    /**
     * 区域地址状态，0无效1有效
     */
    private Byte state;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 团队id
     */
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = s.format(createTime);
        this.createTime = format;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
