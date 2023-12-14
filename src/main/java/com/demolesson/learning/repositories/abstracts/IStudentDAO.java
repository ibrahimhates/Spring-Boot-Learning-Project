package com.demolesson.learning.repositories.abstracts;

import com.demolesson.learning.entity.Student;

import java.util.List;

public interface IStudentDAO {
    void Save(Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void updateFields(Student theStudent);
    void removeStudent(int id);
}
