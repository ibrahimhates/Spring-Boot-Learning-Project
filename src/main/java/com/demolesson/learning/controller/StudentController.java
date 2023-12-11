package com.demolesson.learning.controller;
import com.demolesson.learning.dao.IStudentDAO;
import com.demolesson.learning.entity.Student;
import com.demolesson.learning.exception.notfound.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentDAO studentDAO;

    @Autowired
    public StudentController(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {

        var students = studentDAO.findAll();
        return new ResponseEntity<>(students, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable(name = "id") int id) {
        var student = studentDAO.findById(id);
        if (student == null)
            throw new StudentNotFoundException("Student could not found with id: " + id);
            //throw new StudentBadRequestException("Student could not found with id: " + id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
