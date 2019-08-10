import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class JDBCUtil {
 static String driverClass;
 static String url;
 static String name;
 static String password;
    static{
        try {
            Properties properties = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
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
    public  static Connection getCon() throws SQLException{
        return DriverManager.getConnection(url,name,password);
    }
}
