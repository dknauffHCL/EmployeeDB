package com.danny.service;

import com.danny.UserNotFoundException;
import com.danny.model.Employee;
import com.danny.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee addEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Employee findAllEmployeeById(Integer id) { // no all needed?
        return repo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public List<Employee> findAllEmployees() {
        return repo.findAll();
    }

    public Employee updateEmployee(Employee emp, Integer id) {
        emp.setId(id);
        return repo.save(emp);
    }

    public void deleteEmployee(Integer id) {
        repo.deleteEmployeeById(id);
    }
}
