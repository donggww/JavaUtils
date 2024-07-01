package com.donggw.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.donggw.mapper")
public class MyBatisConfig {
}
