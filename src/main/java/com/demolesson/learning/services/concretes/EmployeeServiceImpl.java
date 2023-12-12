package com.demolesson.learning.services.concretes;

import com.demolesson.learning.dao.abstracts.EmployeeDAO;
import com.demolesson.learning.entity.Employee;
import com.demolesson.learning.exception.notfound.EmployeeNotFoundException;
import com.demolesson.learning.services.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public void createEmployee(Employee theEmployee) {
        employeeDAO.create(theEmployee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee getById(int id) {
        return checkEmployeeExist(id);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee theEmployee) {
        checkEmployeeExist(theEmployee.getId()); // todo Mapp islemi ile bunu mappler gonderırız
        employeeDAO.updateEmployee(theEmployee);
    }

    @Transactional
    @Override
    public void remove(int id) {
        var employee = checkEmployeeExist(id);
        employeeDAO.removeEmployee(employee);
    }

    private Employee checkEmployeeExist(int id){
        var employee = employeeDAO.getById(id);
        if(employee == null)
            throw new EmployeeNotFoundException("Employee could not found with id: "
                    +id);
        return employee;
    }
}
