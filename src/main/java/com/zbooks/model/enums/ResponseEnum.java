package com.zbooks.model.enums;

import lombok.AllArgsConstructor;

/**
 * Description: 响应枚举,2XXX:成功，3XXX:失败
 * Version: 1.0
 * Create Time: 2022/7/16 14:51
 *
 * @author TBH
 */
@AllArgsConstructor
public enum ResponseEnum implements KeyValueEnum<Integer, String> {

    /**
     * 响应成功
     */
    SUCCESS_EXEC(2000, "执行成功!"),
    FAIL_EXEC(3000, "执行失败");

    private final Integer key;
    private final String value;

    @Override
    public Integer getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}