package com.myf.demo.handler;

import com.myf.demo.common.Result;
import com.myf.demo.common.StatusCode;
import com.myf.demo.exception.GlobalException;
import com.myf.demo.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName com.myf.demo.handler GlobalExceptionHandler
 * @Description
 * @Author Afengis
 * @Date 2021/4/12 15:54
 * @Version V1.0
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ResultUtils.fail(globalException.getCode(), globalException.getMessage());
        } else {
            log.error("系统异常", e);
            return ResultUtils.fail(StatusCode.UNKNOWN_ERROR.getCode(), StatusCode.UNKNOWN_ERROR.getMsg());
        }
    }
}
