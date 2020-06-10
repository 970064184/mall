package com.mall.redis.util;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: 分布式锁工具类
 *
 * @author zb
 * @date 2020/5/12 15:45
 */
public class RedissionLock {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 加锁并在逻辑执行完自动解锁
     */
    public void lock(){

    }

}
