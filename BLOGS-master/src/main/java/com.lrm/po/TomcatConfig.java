package com.lrm.po;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;


@Configuration
public class TomcatConfig {

    @Value("10737418240MB")
    private String MaxFileSize;
    @Value("10737418240MB")
    private String MaxRequestSize;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize(MaxFileSize); // KB,MB
        // 总上传数据大小
        factory.setMaxRequestSize(MaxRequestSize);

        return factory.createMultipartConfig();
    }
}