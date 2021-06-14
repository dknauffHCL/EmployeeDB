package com.danny.controller;

import com.danny.model.Employee;
import com.danny.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        Employee newEmp = service.addEmployee(emp);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED); // 201
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> emps = service.findAllEmployees();
        return new ResponseEntity<>(emps, HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getAllEmployeesById(@PathVariable("id") Integer id) {
        Employee emp = service.findAllEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable Integer id) {
        Employee updatedEmp = service.updateEmployee(emp, id);
        return new ResponseEntity<>(updatedEmp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
