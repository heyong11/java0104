package com.peihua.factory;

import com.peihua.service.AccountService;
import com.peihua.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private AccountService accountService;//被代理对象
    private TransactionManager txManager;//代理对象

    //set注入
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     *
                     * @param proxy
                     * @param method 执行目标方法被封装到Method当中
                     * @param args   执行目标方法的参数
                     * @return       执行目标方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returntValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            returntValue = method.invoke(accountService, args);
                            //3.提交事务
                            txManager.commitTransaction();
                            //4.返回结果
                            return returntValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }

                    }
                });

    }

}
