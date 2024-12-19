package com.luisbegazo.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.luisbegazo.employee.dao.DepartmentDao;
import com.luisbegazo.employee.domain.Department;


@Component
public class DepartmentDaoimpl implements DepartmentDao {
    private JdbcTemplate jdbcTemplate;

    public DepartmentDaoimpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Department department) {
        jdbcTemplate.update("INSERT INTO departments (departmentid,departmentname,managerid) VALUES(?,?,?)",
           department.getDepartmentid(),department.getDepartmentName(),department.getManagerid());
        }


    @Override
    public Optional<Department> findOne(int id) {
        List<Department> results = jdbcTemplate.query("SELECT departmentid,departmentname,managerid FROM departments WHERE departmentid = ?",
                                                      new DepartmentRowMapper(),id);

          return results.stream().findFirst();                                            
    }

    public static class DepartmentRowMapper implements org.springframework.jdbc.core.RowMapper<Department>{

        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
           return Department.builder()
                .departmentid(rs.getInt("departmentid"))
                .departmentName(rs.getString("departmentName"))
                .managerid(rs.getLong("managerid"))
                .build();
        }

    }


}


