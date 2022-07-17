package com.zbooks.service.storage.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.TransferProgress;
import com.qcloud.cos.transfer.Upload;
import com.zbooks.config.StorageConfig;
import com.zbooks.model.enums.ExceptionEnum;
import com.zbooks.model.exception.BusinessException;
import com.zbooks.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;

/**
 * Project: zbooks
 * Description:
 * Version: 1.0
 * Create Time: 2022/7/17 17:38
 *
 * @author TBH
 */
@Service
@Slf4j
public class CosServiceImpl implements CosService {

    @Autowired
    StorageConfig storageConfig;

    @Autowired
    BucketServiceImpl bucketService;

    @Value("${cos.bucket-name}")
    String bucketName;

    /**
     * 上传文件
     *
     * @param file    文件
     * @param request http请求
     *
     * @return 上传结果
     */
    public UploadResult upload(MultipartFile multipartFile, HttpServletRequest request) {
        COSClient cosClient = storageConfig.cosClient();
        // 判断桶是否存在
        if (!cosClient.doesBucketExist(bucketName)) {
            bucketService.createBucket(CannedAccessControlList.PublicRead, bucketName);
        }

        UploadResult uploadResult = null;
        TransferManager transferManager = storageConfig.transferManager();
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            // 判断文件是否存在
            boolean objectExists = cosClient.doesObjectExist(bucketName, originalFilename);
            if (objectExists) {
                throw new BusinessException(ExceptionEnum.UPLOAD_FILE_EXIST.getKey(),
                        ExceptionEnum.UPLOAD_FILE_EXIST.getValue());
            }

            File localFile = FileUtils.multipartFileToFile(multipartFile);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(multipartFile.getSize());

            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, originalFilename, localFile);
            Upload upload = transferManager.upload(putObjectRequest);
            showTransferProgress(upload);
            uploadResult = upload.waitForUploadResult();
            System.out.println(uploadResult);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            shutdownTransferManager(transferManager);
        }
        return uploadResult;
    }

    /**
     * 获取上传进度
     *
     * @param transfer 异步上传结果 Upload 的父类
     *
     * @return
     */
    public void showTransferProgress(Transfer transfer) throws InterruptedException {
        System.out.println(transfer.getDescription());
        while (!transfer.isDone()) {
            Thread.sleep(1000);
            TransferProgress progress = transfer.getProgress();
            long sofar = progress.getBytesTransferred();
            long total = progress.getTotalBytesToTransfer();
            double pct = progress.getPercentTransferred();
            System.out.printf("upload progress: [%d / %d] = %.02f%%\n", sofar, total, pct);
        }
        System.out.println(transfer.getState());
    }

    /**
     * 关闭上传线程
     *
     * @param transferManager 传送管理器
     */
    void shutdownTransferManager(TransferManager transferManager) {
        /*
        指定参数为 true, 则同时会关闭 transferManager 内部的 COSClient 实例。
        指定参数为 false, 则不会关闭 transferManager 内部的 COSClient 实例。
        */
        transferManager.shutdownNow(true);
    }

    /**
     * 获取访问url
     *
     * @param key 文件key
     *
     * @return url
     */
    public URL getVisitUrl(String key) {
        return storageConfig.cosClient().getObjectUrl(bucketName, key);
    }

}
