//package com.mall.web;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootTest(classes = MallWebApplication.class)
//class MallWebApplicationTests {
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Test
//    public void test(){
//        String forObject = restTemplate.getForObject("http://localhost:8080/testvoid?param=中国", String.class);
//        System.out.println(forObject);
//    }
//
//
//}
