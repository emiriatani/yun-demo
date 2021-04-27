package com.myf.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team implements Serializable {

    /**
    * 主键列
    */
    private Long id;

    /*
    团队名称
     */
    private String name;

    /**
    * 团队长id
    */
    private Long teamLeader;

    /*
    团队长名称
     */
    private String teamLeaderName;


    /**
    * 管辖区域id
    */
    private Long regionId;

    /*
    管辖区域名称
     */
    private String regionName;

    /**
    * 团队人数
    */
    private Long total;

    /**
    * 团队状态 0无效1有效
    */
    private Byte state;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 删除时间
    */
    private Date deleteTime;

    private static final long serialVersionUID = 1L;
}