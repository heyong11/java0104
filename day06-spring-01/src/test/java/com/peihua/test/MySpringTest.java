package com.peihua.test;

import com.peihua.mapper.UserMapper;
import com.peihua.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MySpringTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        User user = new User();
        user.setName("大娃");
        user.setPwd("123");

        userMapper.saveUser(user);
    }
    //删除
    @Test
    public void test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        userMapper.delete(1);
    }
    //修改
    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = new User();
        user.setName("二娃");
        user.setPwd("123");
        user.setId(2);
        userMapper.update(user);
    }
    //查看一个用户
    @Test
    public void test4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        User user = userMapper.findById(2);
        System.out.println(user);
    }
    //查看用户
    @Test
    public void test5(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        List<User> userList = userMapper.all();
        System.out.println(userList);
    }

}
