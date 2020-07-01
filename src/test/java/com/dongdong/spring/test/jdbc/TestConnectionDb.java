package com.dongdong.spring.test.jdbc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;

/**
 * @Description:
 * @Date: 2020/6/15  18:08
 * @Author: dongdong
 */
public class TestConnectionDb {

    @Test
    public void  testConnect() throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("");
        //2.创建连接
      Connection connection= DriverManager.getConnection("","","");
      //3.创建执行sql对象
       PreparedStatement preparedStatement= connection.prepareStatement("");
       //4.执行sql
       preparedStatement.execute();


    }
}
