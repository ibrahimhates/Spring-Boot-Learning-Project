package com.demolesson.learning.services.abstracts;

import com.demolesson.learning.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee theEmployee);
    List<Employee> getAllEmployees();
    Employee getById(int id);
    void updateEmployee(Employee theEmployee);
    void remove(int id);
}
