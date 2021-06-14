package com.danny.repository;


import com.danny.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Optional<Employee> findEmployeeById(Integer id);

    public void deleteEmployeeById(Integer id);
}
