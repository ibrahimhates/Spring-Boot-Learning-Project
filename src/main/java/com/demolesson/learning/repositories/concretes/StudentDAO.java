package com.demolesson.learning.repositories.concretes;

import com.demolesson.learning.repositories.abstracts.IStudentDAO;
import com.demolesson.learning.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class StudentDAO implements IStudentDAO {
    private final EntityManager manager;

    @Autowired
    public StudentDAO(EntityManager manager) {
        this.manager = manager;
    }

    @Transactional
    @Override
    public void Save(Student theStudent) {
        manager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return manager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll(){
        var query = manager.createQuery("From Student order by lastName",Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        var query = manager
                .createQuery("From Student Where lastName=:theData",Student.class);
        query.setParameter("theData",lastName);

        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateFields(Student theStudent) {
        manager.merge(theStudent);
    }

    @Transactional
    @Override
    public void removeStudent(int id) {
        Student student = findById(id);
        manager.remove(student);
    }
}
