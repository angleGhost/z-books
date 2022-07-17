package com.zbooks.controller.storage;

import com.zbooks.model.entity.Result;
import com.zbooks.model.params.ConfigStorageParam;
import com.zbooks.service.storage.StorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Project: zbooks
 * Description: 存储相关接口
 * Version: 1.0
 * Create Time: 2022/7/16 11:20
 *
 * @author TBH
 */
@RestController
@RequestMapping("api/storage")
@Api(tags = "存储模块")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @ApiOperation("存储配置")
    @PostMapping("config")
    public void configStorage(@RequestBody ConfigStorageParam configStorageParam) {

    }


    @ApiOperation("文件上传")
    @PostMapping("upload")
    public Result upload(@RequestPart("file") MultipartFile file,
                         HttpServletRequest request) {
        // todo: 获取设置的存储位置
        return storageService.upload(file, request);
    }
}
