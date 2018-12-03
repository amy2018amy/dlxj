package com.az.dlxj.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author : az
 * @Create : 2018-11-07 17:35
 * @Desc : RESTful API文档
 */
@Configuration
// 启用Swagger2
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enable}")
    private boolean enableSwagger;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())//用来创建该Api的基本信息（这些基本信息会展现在文档页面中）
                .enable(enableSwagger) // 开发模式下打开，生产环境下关闭
                .select() // 返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
                // 扫描的包所在位置
                .apis(RequestHandlerSelectors.any()) // 为当前包路径
                // 扫描的 URL 规则
                .paths(PathSelectors.any()) // Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）。
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("功能测试")
                //创建人
                .contact(new Contact("Edison", "xxx1@qq.com", "xxx2@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
//                .title("Spring Boot中使用Swagger2构建RESTful APIs")
//                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .contact("程序猿DD")
//                .version("1.0")
//                .build();
    }

}
