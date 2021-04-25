package com.peihua.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * 定义和事务相关的所有代码
 */
@Component //交给sprig处理
@Aspect  //表明是一个切面类  是切点加通知
public class TransactionManager {


    //引入管理连接的工具类：
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.peihua.service.impl.*.*(..))")
    private void point1(){}
    //定义事务开启的方法：
  //  @Before("point1()")
    public void beginTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.setAutoCommit(false);
            System.out.println("我在开启事务");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //定义提交事务的方法：
  //  @AfterReturning("point1()")
    public void commitTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.commit();
            System.out.println("提交成绩");
        } catch (Exception e) {
            System.out.println("提交失败");
            e.printStackTrace();
        }
    }

    //定义回滚方法
   // @AfterThrowing("point1()")
    public void rollbackTransaction(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.rollback();
            System.out.println(12);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(123);
        }
    }

    //定义释放资源：
 //  @After("point1()")
    public  void release(){
        try {
            Connection connection = connectionUtils.getConnection();
            connection.close();
            System.out.println("我刚进来就执行了释放资源");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 环绕通知:
     * spring 框架为我们提供了一个接口：ProceedingJoinPoint，它可以作为环绕通知的方法参数。
     * 在环绕通知执行时，spring 框架会为我们提供该接口的实现类对象，我们直接使用就行。
     * @param pjp
     * @return
     */
    @Around("point1()")
    public Object transactionAround(ProceedingJoinPoint pjp) {
        //定义返回值
        Object returnValue = null;
        try {
            //获取方法执行所需的参数
            Object[] args = pjp.getArgs();
            //前置通知：开启事务
            this.beginTransaction();
            //执行方法
            returnValue = pjp.proceed(args);
            //后置通知：提交事务
            this.commitTransaction();
        }catch(Throwable e) {
            //异常通知：回滚事务
            this.rollbackTransaction();
            e.printStackTrace();
        }finally {
            //最终通知：释放资源
            this.release();
        }
        return returnValue;
    }
}
