package com.zbooks.model.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Project: zbooks
 * Description: 日志枚举类型
 * Version: 1.0
 * Create Time: 2022/7/16 12:38
 *
 * @author TBH
 */
@NoArgsConstructor
@AllArgsConstructor
public enum LogType implements KeyValueEnum<Integer, String> {
    /**
     * Blog initialization
     */
    SYSTEM_INITIALIZED(0, "系统初始化");

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
