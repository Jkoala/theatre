package com.devin.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: simpl
 * @date: 2020/2/27
 * @time: 10:17
 * @description: 
 */

@SpringBootConfiguration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devin.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("devin","simple-le.top","1241169737@qq.com"))
                .title("剧场接口文档")
                .version("v1.0.0")
                .build();
    }
}
