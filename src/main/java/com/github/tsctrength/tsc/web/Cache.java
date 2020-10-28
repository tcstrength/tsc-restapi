package com.github.tsctrength.tsc.web;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class Cache {
    JedisPool pool = null;
    JedisPoolConfig config = new JedisPoolConfig();

    public Cache() {
        config.setMaxIdle(128);
        config.setMaxWaitMillis(5000);
        pool = new JedisPool(config, "localhost", 6379);
    }

    public Long read(String key) {
        var jedis = pool.getResource();
        try {
            String count = jedis.hget(key, "count");
            if (count != null) {
                return Long.parseLong(count);
            }
        } finally {
            jedis.close();
        }

        return -1L;
    }
}
