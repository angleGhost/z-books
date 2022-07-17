package com.zbooks.service.storage.cos;

import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.ListBucketsRequest;

import java.util.List;

/**
 * Project: zbooks
 * Description: 桶相关接口
 * Version: 1.0
 * Create Time: 2022/7/17 13:33
 *
 * @author TBH
 */
public interface BucketService {
    /**
     * 查看腾讯云Cos Bucket列表
     *
     * @return Bucket 列表
     */
    List<Bucket> listBucketCos();

    /**
     * 查看腾讯云Cos Bucket列表
     *
     * @return Bucket 列表
     */
    List<Bucket> listBucketCos(ListBucketsRequest listBucketsRequest);

    /**
     * 创建Bucket
     *
     * @param cannedAcl
     * @param bucketName 桶名称
     *
     * @return Bucket 桶
     */
    Bucket createBucket(CannedAccessControlList cannedAcl, String bucketName);
}