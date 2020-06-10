//package com.mall.web.config;
//
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * Description: spring mvc中文乱码解决
// *
// * @author zb
// * @date 2020/5/18 18:50
// */
//public class CharsetConfig implements WebMvcConfigurer {
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new StringHttpMessageConverter(Charset.forName(StandardCharsets.UTF_8.name())));
//    }
//
//    public static void main(String[] args) {
//        System.out.println(StandardCharsets.UTF_8.name());
//    }
//}
