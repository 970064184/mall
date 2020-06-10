package com.mall.web.config;

import com.mall.web.exception.GlobalExceptionHandler;
import com.mall.web.test.TestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: spring mvc 基础依赖注入
 *
 * @author zb
 * @date 2020/5/18 19:08
 */
@Configuration
public class WebConfig {
    @Bean
    public TestController testController(){
        return new TestController();
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
    
}
