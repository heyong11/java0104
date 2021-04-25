package com.peihua.test;

import com.peihua.factory.MyBeanFactory;
import com.peihua.mapper.UserMapper;

public class Test {
    @org.junit.Test
    public void test1(){
        //1：创建工厂对象
        MyBeanFactory factory =new MyBeanFactory();
        //2：从容器当中根据id获得对象
        UserMapper userDao = (UserMapper) factory.getBean("userMapper");
        System.out.println(userDao);
        userDao.save();
    }

}
