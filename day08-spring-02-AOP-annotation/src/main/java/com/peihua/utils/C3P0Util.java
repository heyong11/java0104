package com.peihua.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 *  引入C3P0 工具类：
 */
public class C3P0Util {

    private static DataSource dataSource = new ComboPooledDataSource("c3p0-config.xml");

    /**
     * 获得数据源的工具方法
     * @return
     */
    public static DataSource getDataSource(){
        return  dataSource;
    }

    /**
     * 获得连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            Connection connection = dataSource.getConnection();
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 定义了释放资源的方法
     * @param connection
     */
    public static void release(Connection connection){
        if(connection !=null){
          try{
              connection.close();
          }catch (Exception e){
              e.printStackTrace();
          }
        }
    }

}
