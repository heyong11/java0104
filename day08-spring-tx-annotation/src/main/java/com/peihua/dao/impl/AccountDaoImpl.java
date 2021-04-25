package com.peihua.dao.impl;

import com.peihua.dao.AccountDao;
import com.peihua.pojo.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findById(Integer id) {
        String sql ="select * from account where id=?";
        Account account = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Account.class),id);
        return account;
    }

    @Override
    public void update(Account account) {
        try {
            String sql ="update account set money=? where id =?";
            jdbcTemplate.update(sql,account.getMoney(),account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
