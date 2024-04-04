package com.ohgiraffers.semiproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Value("${img.macurl}") /* MAC용 이미지 출력 url */
//    private String macPath; /* MAC용 이미지 출력 변수 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");

        // 이미지 불러올 수 있도록 세팅
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///C:/uploadfile/storyimg/");
        // 프로젝트 스토리 첫번째 들어갈 사진 경로
        registry.addResourceHandler("/thumbPath/**")
                .addResourceLocations("file:///C:/uploadfile/Representative_image/");
        // 이게 판매자 사진 경로
        registry.addResourceHandler("/imagePath/**")
                .addResourceLocations("file:///C:/uploadfile/profileimg/");


//        /* MAC용 이미지 출력 */
//
//        // 이미지 불러오기 세팅
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:///" + macPath);
//        // 프로젝트 스토리 첫번째 들어갈 사진 경로
//        registry.addResourceHandler("/thumbPath/**")
//                .addResourceLocations("file:///" + macPath);
//        // 판매자 사진 경로
//        registry.addResourceHandler("/imagePath/**")
//                .addResourceLocations("file:///" + macPath);
    }
}
