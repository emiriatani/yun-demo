package com.myf.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor implements Serializable {
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