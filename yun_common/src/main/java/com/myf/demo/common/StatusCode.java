package com.myf.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @EnumName com.myf.demo.common StatusCode
 * @Description
 * @Author Afengis
 * @Date 2021/4/12 9:15
 * @Version V1.0
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusCode {

    /*通用异常信息*/
    UNKNOWN_ERROR(Constants.SERVER_ERROR,"服务端异常，请联系管理员"),
    REQ_SUCCESS(Constants.SUCCESS,"请求成功"),
    REQ_FAIL(Constants.FAIL,"请求失败"),

    /*权限验证和控制*/
    NO_LOGIN_OPERATION(Constants.FAIL,"未登录操作，请先登录"),

    /*用户模块*/
    NO_ACCOUNT(Constants.FAIL,"该账号未注册，请先注册后再登录"),
    DEACTIVATE_ACCOUNT(Constants.FAIL, "该账号已停用，请联系管理员"),
    NO_ALLOCATE_ACCOUNT(Constants.FAIL,"该账号未分配医生，请先分配后再登录"),
    LOGIN_FAIL(Constants.FAIL,"登录失败，请重试"),
    PWD_ERROR(Constants.FAIL,"用户名和密码不匹配");

    private Integer code;
    private String msg;
}
