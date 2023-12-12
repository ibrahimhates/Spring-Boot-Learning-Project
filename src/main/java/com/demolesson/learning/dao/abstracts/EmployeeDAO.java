package com.demolesson.learning.dao.abstracts;

import com.demolesson.learning.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee theEmployee);
    Employee getById(int id);
    List<Employee> getAll();
    void updateEmployee(Employee theEmployee);
    void removeEmployee(Employee theEmployee);
}
