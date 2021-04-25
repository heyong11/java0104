package com.peihua.test;

import com.peihua.pojo.Person;
import com.peihua.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringRedisTest {

    @Autowired
    JedisPool jedisPool;

    @Test
    public void test1(){
        Jedis resource = jedisPool.getResource();
        String username = resource.get("name");
        System.out.println(username);
        resource.close();
    }
    @Test
    public void testAddPerson2(){

        Jedis jedis = jedisPool.getResource();
        String jsonData=jedis.get("person");
        Person person= JsonUtils.jsonToEntity(jsonData,Person.class);
        System.out.println(person);
        jedis.close();
    }


}
