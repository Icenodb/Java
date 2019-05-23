import java.sql.*;

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
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
