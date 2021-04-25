package com.peihua.dao.impl;

import com.peihua.dao.AccountDao;
import com.peihua.pojo.Account;
import com.peihua.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AccountDaoImpl implements AccountDao {

    // 声明工具类， 管理Connection：
    private ConnectionUtils connectionUtils;
    //使用DButils 完成：
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

    public ConnectionUtils getConnectionUtils() {
        return connectionUtils;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public QueryRunner getQueryRunner() {
        return queryRunner;
    }

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }
}
