package com.zbooks.service.storage.impl;

import com.qcloud.cos.model.UploadResult;
import com.zbooks.model.entity.Result;
import com.zbooks.service.storage.cos.CosServiceImpl;
import com.zbooks.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: zbooks
 * Description: 存储配置类
 * Version: 1.0
 * Create Time: 2022/7/16 11:26
 *
 * @author TBH
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private CosServiceImpl cosService;

    /**
     * @param multipartFile 文件
     * @param request       http请求
     *
     * @return 上传结果
     */
    @Override
    public Result upload(MultipartFile multipartFile, HttpServletRequest request) {
        // todo 获取存储方案，本地、COS、OSS?
        // 储存数据库
        UploadResult cosUpload = cosService.upload(multipartFile, request);
        String key = cosUpload.getKey();
        System.out.println(cosService.getVisitUrl(key));
        return Result.success(cosUpload);
    }

}
