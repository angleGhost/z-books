package com.zbooks;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {
    @Autowired
    private StringEncryptor encryptor;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Test
    @Ignore
    public void contextLoads() {
        System.out.println("MySQL 用户名：" + encryptor.encrypt(username));
        System.out.println("MySQL 密码：" + encryptor.encrypt(password));
        System.out.println("MySQL URl：" + encryptor.encrypt(url));
    }

    @Test
    public void decryptString() {
        System.out.println("MySQL 用户名：" + encryptor.decrypt("message"));
    }
}