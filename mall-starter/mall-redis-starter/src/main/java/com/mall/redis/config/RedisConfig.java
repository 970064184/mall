package com.mall.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Description: Redis相关的初始化配置
 *
 * @author zb
 * @date 2020/5/12 15:43
 */
//@EnableConfigurationProperties(RedisProperties.class)
@Configuration
@Slf4j
public class RedisConfig {


    /**
     * 支持key:value的Redistemplate
     * @param connectionFactory
     * @param redisProperties
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory, RedisProperties redisProperties) {
        log.info("初始化redisTemplate：{}:{}",redisProperties.getHost(),redisProperties.getPort());
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        // 使用Jackson2JsonRedisSerialize替换默认序列化方式
        Jackson2JsonRedisSerializer<?> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //启用默认的类型
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        //序列化类，对象映射设置
        jackson2JsonRedisSerializer.setObjectMapper(om);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


    /**
     * 注入分布式锁
     * @param redisProperties
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(RedissonClient.class)
    public RedissonClient redissonClient(RedisProperties redisProperties){
        log.info("初始化redissonClient：{}:{},{},{}",redisProperties.getHost(),redisProperties.getPort(),redisProperties.getSentinel(), redisProperties.getCluster());
        String scheme = redisProperties.isSsl() ? "rediss://" : "redis://";
        String password = redisProperties.getPassword();

        Config config = new Config();
        if(null != redisProperties.getSentinel()){
            //哨兵模式
            SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
            RedisProperties.Sentinel sentinel = redisProperties.getSentinel();
            sentinelServersConfig.setMasterName(sentinel.getMaster());
            for (String host : sentinel.getNodes()) {
                sentinelServersConfig.addSentinelAddress(scheme + host);
            }
            sentinelServersConfig.setPassword(password);
            // use "rediss://" for SSL connection
               /* .addSentinelAddress("redis://127.0.0.1:26389", "redis://127.0.0.1:26379")
                .addSentinelAddress("redis://127.0.0.1:26319");*/
            log.info("初始化redissonClient哨兵模式");

        }else if(null !=redisProperties.getCluster()){
            //集群模式
            ClusterServersConfig clusterServersConfig = config.useClusterServers();
            RedisProperties.Cluster cluster = redisProperties.getCluster();
            for (String host : cluster.getNodes()) {
                clusterServersConfig.addNodeAddress(scheme + host);
            }
            clusterServersConfig.setPassword(password);
            log.info("初始化redissonClient集群模式");
        }else{
            //单机模式
            config.useSingleServer().setAddress(scheme + redisProperties.getHost() + ":" + redisProperties.getPort()).setPassword(password);
            log.info("初始化redissonClient单机模式");
        }
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

}
