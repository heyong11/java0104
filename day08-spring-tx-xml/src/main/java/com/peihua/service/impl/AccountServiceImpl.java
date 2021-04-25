package com.peihua.service.impl;

import com.peihua.dao.AccountDao;
import com.peihua.pojo.Account;
import com.peihua.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
/*@Transactional*/
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao ;

    @Override
    public void transfer(Integer sourceId, Integer targetid,Double money) {
            //查询来源账户：
            Account sourceAccount = accountDao.findById(sourceId);
            //查询目标账户：
            Account targetAccount = accountDao.findById(targetid);
            //修改来源的金额
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            // 修改目标的金额
            targetAccount.setMoney(targetAccount.getMoney()+money);
            // 持久化到数据库当中：
            accountDao.update(sourceAccount);
            //模拟异常发生：
            int i=1/0;
            accountDao.update(targetAccount);
    }

}
