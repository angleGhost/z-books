package com.zbooks.service.storage.cos;

import com.qcloud.cos.model.UploadResult;
import org.springframework.lang.NonNull;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: zbooks
 * Description: cos 接口
 * Version: 1.0
 * Create Time: 2022/7/17 17:09
 *
 * @author TBH
 */
public interface CosService {
    /**
     * 上传文件
     *
     * @param file    文件
     * @param request http请求
     *
     * @return 上传结果
     */
    UploadResult upload(@NonNull MultipartFile file, HttpServletRequest request);
}
