package com.summer.service.base.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @author Summer
 * @date 2022/3/16 2:03
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("前台API")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/api/.*"))
                .build();
    }

    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("后台API")
                .apiInfo(adminApiInfo())
                .select()
                .paths(PathSelectors.regex("/admin/.*"))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("前台-API文档")
                .description("本文档描述了前台微服务接口定义")
                .version("1.0")
                .contact(new Contact("Summer", "http://summer.com",
                        "511391805@qq.com"))
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("后台-API文档")
                .description("本文档描述了后台微服务接口定义")
                .version("1.0")
                .contact(new Contact("Summer", "http://summer.com",
                        "511391805@qq.com"))
                .build();
    }
}
