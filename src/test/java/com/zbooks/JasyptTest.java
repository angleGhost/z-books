package com.zbooks;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JasyptTest {
    @Autowired
    private StringEncryptor encryptor;

    @Test
    public void contextLoads() {
        System.out.println("====>" + encryptor.encrypt(""));
    }

    @Test
    public void decryptString() {
        System.out.println("====>" + encryptor.decrypt(""));
    }
}