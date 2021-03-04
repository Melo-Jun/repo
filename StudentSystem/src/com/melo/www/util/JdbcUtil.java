package com.melo.www.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

    private static  String url;
    private static  String user;
    private static  String password;
    private static  String driver;
    //静态代码块读取资源文件获取值
    static {
        Properties pro=new Properties();
        try {
            pro.load(new FileReader("src/jdbc.properties"));

            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* public  static Connection getConnetcion(){

     }*/
    //释放资源
    public static void close(Connection conn, Statement stmt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        }
    }
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}

