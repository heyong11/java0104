package com.peihua.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 管理连接的工具类：
 */
public class ConnectionUtils {
    //获得连接： set注入值
    private DataSource dataSource ;

    // 本地线程局部变量， 管理Connection ：
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();


    /**
     * 获得一个连接对象：  只要是同一线程，能够获得同一个Connection。
     * @return
     */
    public Connection getConnection(){
        Connection connection = threadLocal.get();
        if(connection ==null){
            try{
                //如果从本地线程当中获得Connection是null，从池子当中获得一个。
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return connection;

    }


    /**
     * 从局部线程变量当中接触绑定。
     */
    public void release(){
        //接触绑定
        threadLocal.remove();
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
