package com.myf.demo.common;

import lombok.*;

import java.io.Serializable;

/**
 * @ClassName com.myf.demo.common Result
 * @Description 统一返回类
 * @Author Afengis
 * @Date 2021/4/6 15:44
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    @NonNull
    private Boolean isSuccess;
    @NonNull
    private Integer code;
    @NonNull
    private String msg;
    private T data;

//    private static Result<Object> result = null;
//
//    private Result(Boolean isSuccess, Integer code, String msg) {
//        this.isSuccess = isSuccess;
//        this.code = code;
//        this.msg = msg;
//    }
//
//    private Result(Boolean isSuccess, Integer code, String msg, T data) {
//        this.isSuccess = isSuccess;
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }
//
//    public static Result getNoDataInstance(Boolean isSuccess, Integer code, String msg) {
//        if (result == null) {
//            synchronized (Result.class) {
//                if (result == null) {
//                    result = new Result(isSuccess, code, msg);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static Result<Object> getInstance(Boolean isSuccess, Integer code, String msg, Object data) {
//        if (result == null) {
//            synchronized (Result.class) {
//                if (result == null) {
//                    result = new Result<>(isSuccess, code, msg, data);
//                }
//            }
//        }
//        return result;
//    }
}
