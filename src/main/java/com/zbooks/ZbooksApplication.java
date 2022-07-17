package com.zbooks;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * @author TBH
 */
@MapperScan("com.zbooks.mapper")
@SpringBootApplication
@ConfigurationPropertiesScan("com.zbooks.config")
public class ZbooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZbooksApplication.class, args);
    }

}
