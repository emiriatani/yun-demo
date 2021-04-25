package com.myf.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName com.myf.demo.exception GlobalException
 * @Description
 * @Author Afengis
 * @Date 2021/4/12 15:56
 * @Version V1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1293269677619361075L;

    private Integer code;

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
    }
}
