package com.luisbegazo.employee.dao;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.luisbegazo.employee.TestDataUtil;
import com.luisbegazo.employee.dao.impl.EmployeeDaoImpl;
import com.luisbegazo.employee.domain.Employee;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeDaoImplIntegrationTest{

    private EmployeeDaoImpl undertest;

    @Autowired
    public EmployeeDaoImplIntegrationTest(EmployeeDaoImpl undertest){
        this.undertest = undertest;
    }

    @Test
    public void createAndFindEmployee(){
        Employee employee = TestDataUtil.createEmployee();
        undertest.create(employee);
        Optional<Employee> result = undertest.findOne(employee.getEmployeeId());
        
    }

    @Test
    public void testThatCanCreateAndFindMultipleEmployees(){
        Employee employeeA = TestDataUtil.createEmployee();
        undertest.create(employeeA);
        Employee employeeB = TestDataUtil.createEmployeeB();
        undertest.create(employeeB);
        Employee employeeC = TestDataUtil.createEmployeeC();
        undertest.create(employeeC);

        List<Employee> employees = undertest.find();
    }

    @Test
    public void testThatEmployeeCanbeUpdated(){
        Employee employeeA = TestDataUtil.createEmployee();
        undertest.create(employeeA);
        employeeA.setRole("Senior Software Engineer");
        undertest.update(employeeA.getEmployeeId(), employeeA);
        undertest.findOne(employeeA.getEmployeeId());
        
    }

    @Test
    public void testThatCanDeleteAnEmployee(){
        Employee employeeA = TestDataUtil.createEmployee();
        undertest.create(employeeA);
        undertest.delete(employeeA.getEmployeeId());
        Optional<Employee> result =  undertest.findOne(employeeA.getEmployeeId());
        assert(result).isEmpty();
    }

   

}