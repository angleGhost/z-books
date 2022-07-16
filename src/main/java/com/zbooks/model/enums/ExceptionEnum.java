package com.zbooks.model.enums;

import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;

/**
 * Project: zbooks
 * Description: 异常：5xxx
 * Version: 1.0
 * Create Time: 2022/7/16 15:06
 *
 * @author TBH
 */
@AllArgsConstructor
public enum ExceptionEnum implements KeyValueEnum<Integer, String> {
    /**
     * 服务器发生错误
     */
    SERVER_ERROR(5001, "服务器发生未知错误"),
    ;

    private Integer key;
    private String value;

    @Override
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
