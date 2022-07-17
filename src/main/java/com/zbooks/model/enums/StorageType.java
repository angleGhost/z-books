package com.zbooks.model.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public enum StorageType implements KeyValueEnum<Integer, String> {

    /**
     * 本地存储
     */
    LOCAL(0, "Local"),

    /**
     * 腾讯COS存储
     */
    COS(1, "COS"),

    /**
     * 阿里云OSS
     */
    OSS(2, "OSS"),
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