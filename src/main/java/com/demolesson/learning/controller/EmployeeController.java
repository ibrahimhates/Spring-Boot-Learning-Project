package com.demolesson.learning.controller;

import com.demolesson.learning.entity.Employee;
import com.demolesson.learning.services.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return  ResponseEntity.ok(service.getAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getAllEmployee(@PathVariable int id){
        return  ResponseEntity.ok(service.getById(id));
    }
    @PostMapping()
    public void createEmployee(@RequestBody Employee theEmployee){
        service.createEmployee(theEmployee);
    }

    @PutMapping()
    public void updateEmployee(@RequestBody Employee theEmployee){
        service.updateEmployee(theEmployee);
    }

    @DeleteMapping("/{id}")
    public void removeEmployee(@PathVariable int id){
        service.remove(id);
    }
}
