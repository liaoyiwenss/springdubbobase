package net.wanho;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestRedis {


    @Test
//    单机版
    public void testRedis() {
        Jedis jedis = new Jedis("192.168.232.128", 6379);
        jedis.set("testKey", "hello redis");
        String testKey = jedis.get("testKey");
        System.out.println(testKey);
        jedis.close();

    }

    @Test
   //连接池
    public void testRedisPool() {
        JedisPool jedisPool = new JedisPool("192.168.232.128", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("testKey1", "hello redis");
        String testKey1 = jedis.get("testKey1");

        jedis.del("aaa");

        System.out.println(testKey1);
        jedis.close();
        jedisPool.close();
    }


}
