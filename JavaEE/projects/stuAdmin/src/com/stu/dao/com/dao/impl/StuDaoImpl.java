package com.stu.dao.com.dao.impl;

import com.stu.controller.CRUD;
import com.stu.dao.StuDao;
import com.stu.model.Student;
import com.stu.model.User;
import java.util.List;

public class StuDaoImpl implements StuDao {

    @Override
    public boolean addStu(Student stu) {
        CRUD.add(stu);
        return false;
    }

    @Override
    public boolean delStud(int id) {
        CRUD.del(id);
        return false;
    }

    @Override
    public boolean update(Student stu) {
        return false;
    }

    @Override
    public Student findStuById(int id) {
        CRUD.searchById(id);
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }
}
