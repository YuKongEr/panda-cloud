package com.yukong.panda.common.handler;

import com.yukong.panda.common.util.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: yukong
 * @date: 2018/11/13 16:30
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResult exception(Exception e) {
        log.error("发生异常, e={}",e.getMessage(), e);
        return new ApiResult(e);
    }

}
