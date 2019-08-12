package com.stu.dao;
import com.stu.model.Student;
import java.util.List;
/**
 * @author Icenodb
 */
public interface StuDao {
     Student findStuById(int id);
     List findAll();
     boolean addStu(Student stu);
     boolean delStud(int id);
     boolean update(Student stu);
}
