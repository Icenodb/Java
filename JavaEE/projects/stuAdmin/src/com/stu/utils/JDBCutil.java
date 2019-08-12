package com.stu.utils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
public class JDBCutil {
    static String driverClass;
    static String url;
    static String name;
    static String password;
    static{
        try {
            Properties properties = new Properties();
            InputStream is = JDBCutil.class.getClassLoader().getResourceAsStream("com/stu/db.properties");
            properties.load(is);
            driverClass=properties.getProperty("driverClass");
            url=properties.getProperty("url");
            name=properties.getProperty("name");
            password=properties.getProperty("password");
            Class.forName(driverClass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static Connection getCon() throws SQLException {
        return DriverManager.getConnection(url,name,password);
    }
    public static void release(Connection connection, PreparedStatement ps){
        try {
            connection.close();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}