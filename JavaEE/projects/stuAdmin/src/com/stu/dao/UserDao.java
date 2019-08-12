package com.stu.dao;
import com.stu.model.User;

public interface UserDao {
    static boolean login(User user){return false;};
    static boolean updatepsw(User user){return false;};
}
