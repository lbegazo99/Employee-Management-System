package com.luisbegazo.employee.dao;

import java.util.Optional;

import com.luisbegazo.employee.domain.Department;

public interface DepartmentDao {
    
    void create(Department department);

    Optional<Department> findOne(int id);
}
