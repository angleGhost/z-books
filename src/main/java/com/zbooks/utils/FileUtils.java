package com.zbooks.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Project: zbooks
 * Description: 文件处理工具类
 * Version: 1.0
 * Create Time: 2022/7/17 17:40
 *
 * @author TBH
 */
public class FileUtils {
    /**
     * MultipartFile 转 File
     *
     * @param multiFile multiFile对象
     *
     * @return File 对象
     */
    public static File multipartFileToFile(MultipartFile multiFile) {
        // 获取文件名
        String fileName = multiFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 若需要防止生成的临时文件重复,可以在文件名后添加随机码

        try {
            File file = File.createTempFile(fileName, prefix);
            multiFile.transferTo(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
