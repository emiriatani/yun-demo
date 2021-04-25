package com.myf.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record implements Serializable {
    /**
    * 主键列
    */
    private Long id;

    /**
    * 所属区域id
    */
    private Long regionId;

    /**
    * 所属账号id
    */
    private Long userId;

    /**
    * 所属医生id
    */
    private Long doctorId;

    /**
    * 姓名
    */
    private String name;

    /**
    * 性别，0女1男
    */
    private Byte gender;

    /**
    * 出生日期
    */
    private Date birth;

    /**
    * 身份证
    */
    private Long idCard;

    /**
    * 是否高血压患者，0否1是
    */
    private Byte hypertension;

    /**
    * 是否糖尿病患者，0否1是
    */
    private Byte diabetes;

    /**
    * 个人档案状态 0无效1有效
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