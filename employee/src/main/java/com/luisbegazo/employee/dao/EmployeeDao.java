package com.luisbegazo.employee.dao;

import java.util.List;
import java.util.Optional;

import com.luisbegazo.employee.domain.Employee;

public interface EmployeeDao {
    void create(Employee employee);

    Optional<Employee> findOne(long l);

    List<Employee> find();

    void update(Long id , Employee employee);

    void delete(long id);
    
}
