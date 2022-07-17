package com.zbooks.model.params;

import lombok.Data;

import java.util.Map;

/**
 * Project: zbooks
 * Description: 配置存储参数
 * Version: 1.0
 * Create Time: 2022/7/16 12:26
 *
 * @author TBH
 */
@Data
public class ConfigStorageParam {

    /**
     * 配置类型
     */
    private Integer configType;

    /**
     * 配置参数
     */
    private Map<String, String> params;
}
