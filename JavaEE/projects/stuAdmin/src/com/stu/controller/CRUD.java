package com.stu.controller;

import com.stu.dao.StuDao;
import com.stu.model.Student;
import com.stu.model.User;
import com.stu.utils.JDBCutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CRUD {

    public static void run(String sql){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn = JDBCutil.getCon();
            ps = conn.prepareStatement(sql);
            ps.execute(sql);
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            JDBCutil.release(conn, ps);
        }
    }
    public static void add(Student stu) {
        if(true){
        String sql="insert INTO stu"+" values "
                +"("+stu.getId()+","
                +"'"+stu.getName()+"'"+","
                +"'"+stu.getSex()+"'"+","
                +stu.getAge()+","
                +"'"+stu.getMajor()+"')";
        CRUD.run(sql);
        }else{

        }
    }
    public static void del(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="delete from stu where id="+id;
        CRUD.run(sql);
    }
    public static void update(Student stu){
    }
    public static List<Student> getAll(){

        return null;
    }
    public static boolean searchById(int id){
        String sql="SELECT * FROM stu WHERE id="+id;
        CRUD.run(sql);
        return false;
    }
}