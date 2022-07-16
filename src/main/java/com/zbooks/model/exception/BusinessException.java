package com.zbooks.model.exception;

import com.zbooks.model.enums.ExceptionEnum;
import lombok.Data;

/**
 * Project: zbooks
 * Description:
 * Version: 1.0
 * Create Time: 2022/7/16 15:15
 *
 * @author TBH
 */
@Data
public class BusinessException extends RuntimeException {
    private Integer status;
    private String message;

    public BusinessException(ExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getKey();
        this.message = exceptionEnum.getValue();
    }

    public BusinessException(Integer code, String message) {
        this.status = code;
        this.message = message;
    }
}