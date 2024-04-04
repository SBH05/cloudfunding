package com.ohgiraffers.semiproject.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.semiproject", annotationClass = Mapper.class)
public class MybatisConfig {

}
