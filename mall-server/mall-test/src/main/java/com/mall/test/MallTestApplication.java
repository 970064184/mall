package com.mall.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @author zb
 * @date 2020/5/20 14:29
 */
@SpringBootApplication
public class MallTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallTestApplication.class,args);
    }
    @Value("${common.test}")
    private String common;

    @Bean
    public void test(){
        System.out.println(common);
    }

    @Autowired
    private RestTemplate restTemplate;
}
