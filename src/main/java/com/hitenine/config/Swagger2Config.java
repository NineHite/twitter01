package com.hitenine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * swagger
 * @author Hitenine
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket docket(Environment environment) {

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev"); //"prod" 可以为多个
        //获取当前项目的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Nine") //设置分组为自己
                .enable(flag) //默认true 设置如果为dev环境开启
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hitenine.controller")) //none() any() withClassAnnotation(GetMapping)
                // .paths(PathSelectors.any())
                .build();
    }

    //配置swagger信息aipInfo()
    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("NineHite", "https://www.cnblogs.com/hitenine/", "1751050890@qq.com");

        // new ApiInfoBuilder().title()

        return new ApiInfo(
                "blog",
                "Blog接口测试",
                "1.0",
                "https://www.cnblogs.com/hitenine/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
