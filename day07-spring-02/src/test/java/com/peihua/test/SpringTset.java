package com.peihua.test;
import com.peihua.configuration.SpringConfiguration;
import com.peihua.pojo.User;
import com.peihua.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTset {

    @Test
    public void test1() {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //基于注解模式的工厂对象 ，读取核心配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setName("22");
        user.setPwd("123");
        userService.saveUser(user);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        userService.delByIdService(2);
    }
    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = new User();
        user.setName("赛文");
        user.setPwd("123");
        user.setId(3);
        userService.upService(user);
    }
    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.findByIdService(3);
        System.out.println(user);
    }
    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean("userService", UserService.class);
        List<User> users = userService.selAllService();
        System.out.println(users    );
    }

}