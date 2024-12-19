package com.luisbegazo.employee.dao;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.luisbegazo.employee.TestDataUtil;
import com.luisbegazo.employee.dao.impl.DepartmentDaoimpl;
import com.luisbegazo.employee.domain.Department;

@ExtendWith(MockitoExtension.class)

public class DepartmentDaoImplTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private DepartmentDaoimpl underTest;


    @Test
    public void DepartmentCreationTest(){
        Department department = TestDataUtil.createDepartment();

        underTest.create(department);

        verify(jdbcTemplate).update(
            eq("INSERT INTO departments (departmentid,departmentName,managerid) VALUES(?,?,?)"),
            eq(1),
            eq("Engineering"),
            eq(1L)
        );
    }


}
