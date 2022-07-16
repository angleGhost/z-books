package com.zbooks.model.entity;

import com.zbooks.model.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project: zbooks
 * Description:
 * Version: 1.0
 * Create Time: 2022/7/16 15:05
 *
 * @author TBH
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    /**
     * 异常的状态码
     */
    private Integer status;

    /**
     * 异常的消息，写用户看得懂的异常，从枚举中得到
     */
    private String message;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 对异常处理进行统一封装
     */
    public static ErrorResult fail(ExceptionEnum exceptionEnum, Throwable throwable, String message) {
        ErrorResult errorHandler = ErrorResult.fail(exceptionEnum, throwable);
        errorHandler.setMessage(message);
        return errorHandler;
    }

    /**
     * 对异常枚举进行封装
     */
    public static ErrorResult fail(ExceptionEnum exceptionEnum, Throwable throwable) {
        ErrorResult errorHandler = new ErrorResult();
        errorHandler.setStatus(exceptionEnum.getKey());
        errorHandler.setMessage(exceptionEnum.getValue());
        errorHandler.setException(throwable.getClass().getName());
        return errorHandler;
    }
}
