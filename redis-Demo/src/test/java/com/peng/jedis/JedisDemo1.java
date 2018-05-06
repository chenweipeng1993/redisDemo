package com.peng.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo1 {
    @Test
    public void demo1(){
        //1.设置ip和端口
        Jedis jedis = new Jedis("192.168.31.244",6379);
        //2.保存数据
        jedis.set("name","hello world redis");
        //3.获取数据
        String name = jedis.get("name");
        System.out.println(name);
        //4.释放资源
        jedis.close();

    }
    @Test
    /**
     * 连接池方式连接
     */
    public void demo2(){
        //获得连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大的连接数
        config.setMaxTotal(30);
        //设置最大的空闲连接数
        config.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool = new JedisPool(config,"127.0.0.1",6379);

        //获取jedis核心对象
        Jedis jedis = null;
        try {
            //通过连接池获取连接
            jedis = jedisPool.getResource();
            //设置数据
            jedis.set("name","hello world jedisPool");
            //获取数据
            String value = jedis.get("name");
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (jedis!=null){
                jedis.close();
            }
            if (jedisPool!=null){
                jedisPool.close();
            }

        }
    }
}
