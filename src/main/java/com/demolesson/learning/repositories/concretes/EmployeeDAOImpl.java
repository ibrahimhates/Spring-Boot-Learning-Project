package com.demolesson.learning.repositories.concretes;

import com.demolesson.learning.repositories.abstracts.EmployeeDAO;
import com.demolesson.learning.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final EntityManager manager;

    @Autowired
    public EmployeeDAOImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void create(Employee theEmployee) {
        manager.persist(theEmployee);
    }

    @Override
    public Employee getById(int id) {
        return manager.find(Employee.class,id);
    }

    @Override
    public List<Employee> getAll() {
        return manager
                .createQuery("From Employee",Employee.class)
                .getResultList();
    }

    @Override
    public void updateEmployee(Employee theEmployee) {
        manager.merge(theEmployee);
    }

    @Override
    public void removeEmployee(Employee theEmployee) {
        manager.remove(theEmployee);
    }
}
