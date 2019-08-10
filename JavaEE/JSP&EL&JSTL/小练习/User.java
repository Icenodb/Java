import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User implements UserDao {
    @Override
    public boolean login(String name,String psw) {
        try{
            Connection connection=JDBCUtil.getCon();
            System.out.println("数据库状态:"+connection.isClosed());
            String sql="select * from user where name=? and password=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,psw);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("name")+"=======登陆成功");
                return true;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<UserInfo> findAll(boolean isFlase) throws SQLException{
        if(isFlase){
            Connection connection=JDBCUtil.getCon();
            String sql="select * from studentInfo";
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(sql);
            List<UserInfo> users=new ArrayList<UserInfo>();
            while(rs.next()){
                users.add(new UserInfo( rs.getString("name"),rs.getString("age")));
            }
            return users;
        }
        return null;
    }
}
