//Dao describe the rule of access to the UserTable;
//login success------>return userInfo
//login false-------->return false
public interface UserDao {
    boolean login(String name,String password);
}
