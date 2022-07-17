package com.zbooks.service.storage;

import com.zbooks.model.entity.Result;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: zbooks
 * Description: 存储配置
 * Version: 1.0
 * Create Time: 2022/7/16 11:25
 *
 * @author TBH
 */
public interface StorageService {
    /**
     * 上传文件
     *
     * @param file    文件
     * @param request http请求
     *
     * @return 上传结果
     */
    Result upload(@NonNull MultipartFile file, HttpServletRequest request);
}
