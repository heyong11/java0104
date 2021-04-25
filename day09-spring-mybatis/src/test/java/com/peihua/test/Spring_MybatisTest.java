package com.peihua.test;

import com.peihua.pojo.User;
import com.peihua.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Spring_MybatisTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUserTest(){
        User user = new User();
        user.setName("老八");
        user.setPwd("123");
        userService.saveUser(user);
    }
    @Test
    public void deleteByIdTest(){
        userService.deleteById(10);
    }
    @Test
    public void upUserTest(){
        User user = new User();
        user.setName("奥特曼");
        user.setPwd("123");
        user.setId(11);
        userService.upUser(user);
    }
    @Test
    public void findByIdTest(){
        User user = userService.findById(11);
        System.out.println(user);
    }
    @Test
    public void findAllTest(){
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }



}
