package com.peihua.dao;

import com.peihua.pojo.Account;

// data access object
public interface AccountDao {

    //查询：
    Account findById(Integer id);

    //定义修改方法：
    void update(Account account);

}
