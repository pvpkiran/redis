package in.phani.springboot.redis.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Accessing redis using Redis Template
 */
@Service
public class RedisTemplateService {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisTemplateService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public String getFromRedis(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void putToRedis(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }
}
