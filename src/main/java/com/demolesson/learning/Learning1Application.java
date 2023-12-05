package com.demolesson.learning;

import com.demolesson.learning.dao.IStudentDAO;
import com.demolesson.learning.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Learning1Application {

    public static void main(String[] args) {
        SpringApplication.run(Learning1Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(IStudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);

           // createMultibleStudent(studentDAO);
            //findStudent(studentDAO);
            findAll(studentDAO);
        };
    }

    private void findAll(IStudentDAO studentDAO) {
        System.out.println(studentDAO.findAll());
    }

    private void findStudent(IStudentDAO studentDAO) {
        var student = studentDAO.findById(2);
        System.out.println(student.toString());
    }
    private void createMultibleStudent(IStudentDAO studentDAO) {
        Student tempStudent = new Student("Ibrahim","Ates","atesibrahim@gmail.com");
        Student tempStudent1 = new Student("Ibrahim2","Ates2","atesibrahim@gmail.com");
        Student tempStudent2 = new Student("Ibrahim3","Ates3","atesibrahim@gmail.com");
        studentDAO.Save(tempStudent);
        studentDAO.Save(tempStudent2);
        studentDAO.Save(tempStudent1);
        System.out.println("Created");
    }

    private void createStudent(IStudentDAO studentDAO) {
        Student tempStudent = new Student("Ibrahim","Ates","atesibrahim@gmail.com");
        studentDAO.Save(tempStudent);
        System.out.println("Created");
    }
}
