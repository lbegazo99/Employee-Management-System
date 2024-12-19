package com.luisbegazo.employee.dao;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luisbegazo.employee.TestDataUtil;
import com.luisbegazo.employee.dao.impl.DepartmentDaoimpl;
import com.luisbegazo.employee.domain.Department;
import com.luisbegazo.employee.domain.Employee;

@SpringBootTest
@ExtendWith(SpringExtension.class)

public class DepartmentDaoImplIntegrationTests {
    private EmployeeDao employeeDao;
    private DepartmentDaoimpl underTest;

    @Autowired
    public DepartmentDaoImplIntegrationTests(DepartmentDaoimpl underTest,EmployeeDao employeeDao){
        this.underTest = underTest;
        this.employeeDao = employeeDao;
    }

    @Test 
    public void createAndFindDepartment(){
        Employee employee = TestDataUtil.createEmployee();
        employeeDao.create(employee);
        Department department = TestDataUtil.createDepartment();
        department.setManagerid(employee.getEmployeeId());
        underTest.create(department);
        Optional<Department> result = underTest.findOne(department.getDepartmentid());
        
        
    }
}
