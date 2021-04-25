package com.peihua.service;

public interface AccountService {

    /**
     * 业务方法：
     * @param sourceId 来源账户
     * @param targerId 目标账户
     * @param money 转账金额
     */
    public void transfer(Integer sourceId, Integer targerId, Double money);
}
