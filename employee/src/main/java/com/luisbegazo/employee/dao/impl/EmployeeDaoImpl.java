package com.luisbegazo.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.luisbegazo.employee.dao.EmployeeDao;
import com.luisbegazo.employee.domain.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Employee employee) {
        jdbcTemplate.update("INSERT INTO employees (employeeid,name,dob,gender,number,role,salary,isManager) VALUES(?,?,?,?,?,?,?,?)" ,
            employee.getEmployeeId(),employee.getName(),employee.getDob(),employee.getGender(),employee.getNumber(),employee.getRole(),employee.getSalary(),employee.isManager());
    }


    @Override
    public Optional<Employee> findOne(long id) {
       List<Employee> results = jdbcTemplate.query("SELECT employeeid,name,dob FROM employees WHERE employeeid = ?",
                                 new EmployeeRowMapper(),id);

        return results.stream().findFirst();
    }

    public static class EmployeeRowMapper implements org.springframework.jdbc.core.RowMapper<Employee>{

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
           return Employee.builder()
                .employeeId(rs.getLong("employeeId"))
                .name(rs.getString("name"))
                .dob(rs.getString("dob"))
                .build();
        }

    }

    @Override
    public List<Employee> find() {
        return jdbcTemplate.query(
            "SELECT employeeid,name,dob FROM employees",
            new EmployeeRowMapper()
        );
    }


    @Override
    public void update(Long id ,Employee employee) {
       jdbcTemplate.update("UPDATE employees SET employeeid = ?, name = ?, dob = ?, gender = ?, number = ?, role = ?, salary = ?, isManager = ? WHERE employeeid = ?",
        employee.getEmployeeId(),employee.getName(),employee.getDob(),employee.getGender(),employee.getNumber(),employee.getRole(),employee.getSalary(),employee.isManager(),id);
    }


    @Override
    public void delete(long id) {
        jdbcTemplate.update(
           "DELETE FROM employees where employeeid = ?",id);
    }


   
}
