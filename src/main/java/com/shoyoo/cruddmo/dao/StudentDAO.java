package com.shoyoo.cruddmo.dao;

import com.shoyoo.cruddmo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student find(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
