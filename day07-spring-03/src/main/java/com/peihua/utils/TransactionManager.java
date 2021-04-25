package com.peihua.utils;


import java.sql.Connection;

/**
 * 定义和事务相关的所有代码
 */
public class TransactionManager {

    //引入管理连接的工具类：
    private ConnectionUtils connectionUtils;

    //定义事务开启的方法：
    public void beginTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义提交事务的方法：
    public void commitTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义回滚方法
    public void rollbackTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义释放资源：
    public  void release(){
        try {
            connectionUtils.getConnection().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    public Object transactionAround(ProceedingJoinPoint pjp) {
//        //定义返回值
//        Object returnValue = null;
//        try {
//            //获取方法执行所需的参数
//            Object[] args = pjp.getArgs();
//            //前置通知：开启事务
//            beginTransaction();
//            //执行方法
//            returnValue = pjp.proceed(args);
//            //后置通知：提交事务
//            commit();
//        }catch(Throwable e) {
//            //异常通知：回滚事务
//            rollback();
//            e.printStackTrace();
//        }finally {
//            //最终通知：释放资源
//            release();
//        }
//        return returnValue;
//    }


    public ConnectionUtils getConnectionUtils() {
        return connectionUtils;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
}
