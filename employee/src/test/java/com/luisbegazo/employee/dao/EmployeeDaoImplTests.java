package com.luisbegazo.employee.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import javax.swing.tree.RowMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.http.client.reactive.JdkClientHttpConnector;
import org.springframework.jdbc.core.JdbcTemplate;

import com.luisbegazo.employee.TestDataUtil;
import com.luisbegazo.employee.dao.impl.EmployeeDaoImpl;
import com.luisbegazo.employee.domain.Employee;

import net.bytebuddy.asm.Advice.Argument;

@ExtendWith(MockitoExtension.class)

public class EmployeeDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private EmployeeDaoImpl underTest;

    @Test
    public void EmployeeCreationTest(){
        Employee employee = TestDataUtil.createEmployee();

            underTest.create(employee);

            verify(jdbcTemplate).update(
                eq("INSERT INTO employees (employeeid,name,dob,gender,number,role,salary,isManager) VALUES(?,?,?,?,?,?,?,?)"),
                eq(1L),
                eq("Luis Begazo"),
                eq("10/14/1999"),
                eq('m'),
                eq("929-490-5016"),
                eq("senior software engineer"),
                eq(140000),
                eq(true)
                );
    }

    @Test 
    public void FindEmployee(){
        underTest.findOne(1L);
        verify(jdbcTemplate).query(
            eq("SELECT employeeid,name,dob FROM employees WHERE employeeid = ?"),
            ArgumentMatchers.<EmployeeDaoImpl.EmployeeRowMapper>any(),
            eq(1L)
        );
    }


    @Test
    public void findManyEmployees(){
        underTest.find();
        verify(jdbcTemplate).query(
            eq("SELECT employeeid,name,dob FROM employees"),
            ArgumentMatchers.<EmployeeDaoImpl.EmployeeRowMapper>any()
        );
    }

    @Test
    public void testThatCanUpdateAnEmployee(){
        Employee employee = TestDataUtil.createEmployeeC();
        underTest.update(4L,employee);


        verify(jdbcTemplate).update(
            "UPDATE employees SET employeeid = ?, name = ?, dob = ?, gender = ?, number = ?, role = ?, salary = ?, isManager = ? WHERE employeeid = ?",
            3L,"Greg Jones","9/21/2003",'m',"347-785-4531","Junior software engineer",90000,false,4L
        );
    }

    @Test
    public void testThatCanDeleteAnEmployee(){
        underTest.delete(1L);
        verify(jdbcTemplate).update(
            "DELETE FROM employees where employeeid = ?",
            1L
        );
    }
   
    



}
