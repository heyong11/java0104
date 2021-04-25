package com.peihua;


import com.peihua.config.SpringConfig;
import com.peihua.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestAccountService {


    @Resource //自动装配：
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer(1001,1003,100D);
    }




}
