package com.peihua;


import com.peihua.config.SpringConfig;
import com.peihua.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestAccountService {

   /*@Test
    public void testTransfer(){
       //获得service对象
       AccountServiceImpl service = new AccountServiceImpl();
       service.transfer(1001,1003,100);
   }*/


    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transfer(1001,1003,100D);
    }
}
