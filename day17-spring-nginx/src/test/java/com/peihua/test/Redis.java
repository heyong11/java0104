package com.peihua.test;

import com.peihua.pojo.Person;
import com.peihua.util.JsonUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Redis {
    @Test
    public void test1()throws Exception{
        String host = "192.168.197.20";
        Integer port = 6379;

        Jedis jedis = new Jedis(host,port);
        jedis.set("name","huluwa");

        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
    @Test
    public void test()throws Exception{
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(3);
        poolConfig.setMaxTotal(5);

        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常
        poolConfig.setMaxWaitMillis(30000);
        //在获取连接的时候检查有效性
        poolConfig.setTestOnBorrow(true);

        JedisPool jedisPool = new JedisPool(poolConfig,"192.168.197.20",6379,30000);

        Jedis jedis = jedisPool.getResource();
        jedis.set("age","nv");
        jedis.set("addres","xian");

        String age = jedis.get("age");
        System.out.println(age);
    }
    @Test
    public void testAddPerson(){
        //创建JedisPoolConfig对象
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        //最大空闲连接数
        poolConfig.setMaxIdle(3);
        //大连接数
        poolConfig.setMaxTotal(5);
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        poolConfig.setBlockWhenExhausted(true);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常
        poolConfig.setMaxWaitMillis(30000);
        //在获取连接的时候检查有效性
        poolConfig.setTestOnBorrow(true);


        JedisPool jedisPool=new JedisPool(poolConfig,"192.168.197.20",6379,30000);
        Person person=new Person(100,"张三","男",22);
        Jedis jedis = jedisPool.getResource();
        jedis.set("person", JsonUtils.objectToJson(person));
        //jedis.hset("persons",person.getName(), JsonUtils.objectToJson(person));
        jedis.close();
    }

    @Test
    public void testAddPerson2(){

        //创建JedisPoolConfig对象
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        //最大空闲连接数
        poolConfig.setMaxIdle(3);
        //大连接数
        poolConfig.setMaxTotal(5);
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        poolConfig.setBlockWhenExhausted(true);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常
        poolConfig.setMaxWaitMillis(30000);
        //在获取连接的时候检查有效性
        poolConfig.setTestOnBorrow(true);
        JedisPool jedisPool=new JedisPool(poolConfig,"192.168.197.20",6379,30000);
        Jedis jedis = jedisPool.getResource();
        String jsonData=jedis.get("person");
        Person person=JsonUtils.jsonToEntity(jsonData,Person.class);
        System.out.println(person);
        jedis.close();
    }
}
