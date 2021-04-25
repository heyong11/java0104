package com.peihua.dao.impl;

import com.peihua.dao.AccountDao;
import com.peihua.pojo.Account;
import com.peihua.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class AccountDaoImpl implements AccountDao {

    // 声明工具类， 管理Connection：
    @Autowired
    private ConnectionUtils connectionUtils;
    //使用DButils 完成：
    @Autowired
    private QueryRunner queryRunner  ;

    @Override
    public Account findById(Integer id) {
        try{
            String sql ="select * from account where id=?";
            Account account = queryRunner.query(connectionUtils.getConnection(),sql, new BeanHandler<>(Account.class), id);

            return account;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Account account) {
        try {
            String sql ="update account set money=? where id =?";
            queryRunner.update(connectionUtils.getConnection(),sql,account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
