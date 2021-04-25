package com.myf.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 主键列
     */
    private Long id;

    /**
     * 登录用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 该账号分配医生id
     */
    private Long assignor;

    /**
     * 账号分配状态,0未分配1已分配
     */
    private Byte allocationStatus;

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

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 账号状态,0停用1启用
     */
    private Byte status;

    private static final long serialVersionUID = 1L;
}