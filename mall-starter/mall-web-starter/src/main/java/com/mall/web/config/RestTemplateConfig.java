package com.mall.web.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Description: RestTemplate 初始化配置
 *
 * @author zb
 * @date 2020/5/12 16:56
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        RestTemplate restTemplate =restTemplateBuilder/*.errorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;//返回false表示不管response的status是多少都返回没有错
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
            //这里面可以实现遇到了Error进行合理的处理

            }
        })*/
//                .setConnectTimeout() //设置超时时间
//                .setReadTimeout()
                .build();
        //统一处理中文乱码问题
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }


}
