package com.zbooks.handler;

import com.zbooks.model.entity.ErrorResult;
import com.zbooks.model.enums.ExceptionEnum;
import com.zbooks.model.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 全局异常处理器
 * Version: 1.0
 * Create Time: 2022/7/16 15:19
 *
 * @author TBH
 */

@Slf4j
@RestControllerAdvice(basePackages = "com.zbooks")
public class GlobalExceptionHandler {

    /**
     * 对服务器端出现500异常进行统一处理
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult makeException(Throwable e, HttpServletRequest request) {
        ErrorResult errorResult = ErrorResult.fail(ExceptionEnum.SERVER_ERROR, e);
        log.error("请求的地址是：{},出现的异常是：{}", request.getRequestURL(), e);
        return errorResult;
    }


    /**
     * 对自定义异常进行统一处理
     */
    @ExceptionHandler(BusinessException.class)
    public ErrorResult makeException(BusinessException e, HttpServletRequest request) {
        ErrorResult errorResult = ErrorResult.builder()
                .status(e.getStatus())
                .message(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.error("请求的地址是：{},BusinessException出现异常：{}", request.getRequestURL(), e);
        return errorResult;
    }
}