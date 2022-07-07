package com.zbooks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author TBH
 */
@Configuration
@EnableSwagger2
public class Knife4jConfiguration {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("之书 RESTful APIs")
                        .description("# 之书图书管理项目")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact(
                                "TBH",
                                "https://www.workingcoder.work",
                                "")
                        )
                        .version("1.0")
                        .build())
                .groupName("1.0.0 version")
                .select()
                //Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.zbooks"))
                .paths(PathSelectors.any())
                .build();
    }
}