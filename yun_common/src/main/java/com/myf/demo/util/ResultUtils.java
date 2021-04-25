package com.myf.demo.util;

import com.myf.demo.common.Result;

/**
 * @ClassName com.myf.demo.util ResultUtils
 * @Description  生成统一返回类的工具类
 * @Author Afengis
 * @Date 2021/4/12 9:10
 * @Version V1.0
 **/
public class ResultUtils {

    /*请求成功，不带数据*/
    public static Result<Object> success(Integer code, String msg){
        return new Result<>(Boolean.TRUE, code, msg);
    }

    /*请求成功，带数据*/
    public static Result<Object> success(Integer code, String msg, Object data){
        return new Result<>(Boolean.TRUE, code, msg,data);
    }

    /*请求失败，不带数据*/
    public static Result<Object> fail(Integer code, String msg){
        return new Result<>(Boolean.FALSE, code, msg);
    }

    /*请求失败，带数据*/
    public static Result<Object> fail(Integer code, String msg, Object data){
        return new Result<>(Boolean.FALSE, code, msg,data);
    }



}
