package com.peihua.service.impl;

import com.peihua.dao.AccountDao;
import com.peihua.pojo.Account;
import com.peihua.service.AccountService;
import com.peihua.utils.TransactionManager;

public class AccountServiceImpl implements AccountService {

    private TransactionManager transactionManager;//定义了事务相关的方法：
    private AccountDao accountDao ;

    @Override
    public void transfer(Integer sourceId, Integer targetid,Double money) {

            //开始事务：
//            transactionManager.beginTransaction();
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
            //事务提交：
//            transactionManager.commitTransaction();
        }


    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
