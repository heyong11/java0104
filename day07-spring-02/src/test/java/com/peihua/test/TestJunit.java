package com.peihua.test;

import com.peihua.configuration.SpringConfiguration;
import com.peihua.pojo.User;
import com.peihua.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit底层反射调用了main方法
@ContextConfiguration(classes = SpringConfiguration.class) //配置类地址
//ContextConfiguration 也可以读取xml文件，一样的写法
public class TestJunit {

    @Autowired
    private UserService userService;

    @Test
    public void test1(){
        User user = new User();
        user.setName("ss");
        user.setPwd("sss");
        userService.saveUser(user);

    }


}
