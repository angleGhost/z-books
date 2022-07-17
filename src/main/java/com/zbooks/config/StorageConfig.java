package com.zbooks.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.transfer.TransferManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project: zbooks
 * Description:
 * Version: 1.0
 * Create Time: 2022/7/17 13:29
 *
 * @author TBH
 */
@Configuration
public class StorageConfig {
    @Autowired
    CosClientConfig cosClientConfig;

    @Bean
    public COSClient cosClient() {
        return cosClientConfig.getCosClient();
    }

    @Bean
    public TransferManager transferManager() {
        return cosClientConfig.createTransferManager();
    }
}
