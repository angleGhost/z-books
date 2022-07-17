package com.zbooks.service.storage.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.CreateBucketRequest;
import com.qcloud.cos.model.ListBucketsRequest;
import com.zbooks.config.StorageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project: zbooks
 * Description: COS桶操作
 * Version: 1.0
 * Create Time: 2022/7/17 13:33
 *
 * @author TBH
 */
@Service
public class BucketServiceImpl implements BucketService {
    @Autowired
    StorageConfig storageConfig;

    @Override
    public List<Bucket> listBucketCos() {
        return storageConfig.cosClient().listBuckets();
    }


    /**
     * 查看所有的桶
     *
     * @param listBucketsRequest 入参
     *
     * @return
     */
    public List<Bucket> listBucketCos(ListBucketsRequest listBucketsRequest) {
        return storageConfig.cosClient().listBuckets(listBucketsRequest);
    }

    /**
     * 创建Bucket
     *
     * @param cannedAcl
     * @param bucketName 桶名称
     *
     * @return Bucket 桶
     */
    public Bucket createBucket(CannedAccessControlList cannedAcl, String bucketName) {
        COSClient cosClient = storageConfig.cosClient();
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
        createBucketRequest.setCannedAcl(CannedAccessControlList.PublicRead);
        Bucket bucketResult = cosClient.createBucket(createBucketRequest);
        // todo: 记录操作日志
        System.out.println(bucketResult);
        return bucketResult;
    }
}
