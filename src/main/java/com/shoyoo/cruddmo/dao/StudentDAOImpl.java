package com.shoyoo.cruddmo.dao;

import com.shoyoo.cruddmo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using contructor
    // Autowired optional if we have only one constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student){
        entityManager.persist(student);
    }

    // Implement find method ( get )
    @Override
    public Student find(Integer id){
       return entityManager.find(Student.class, id);
    }

    // implement find all students
    @Override
    public List<Student> findAll(){
        TypedQuery<Student> getStudents = entityManager.createQuery("FROM Student", Student.class);
        return getStudents.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName){

       TypedQuery<Student> studentQuery = entityManager.createQuery(
               "FROM Student WHERE lastName = :theData", Student.class);

       // set query parameter : theData
       studentQuery.setParameter("theData", theLastName);

       return studentQuery.getResultList();
    }



}
