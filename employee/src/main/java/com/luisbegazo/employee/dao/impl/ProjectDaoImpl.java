package com.luisbegazo.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;

import com.luisbegazo.employee.dao.ProjectDao;
import com.luisbegazo.employee.domain.Project;

public class ProjectDaoImpl implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    public ProjectDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Project project) {
       jdbcTemplate.update("INSERT INTO projects (projectId,projectName,projectBudget,departmentid,employeeid) VALUES(?,?,?) ",
       project.getProjectId(),project.getProjectName(),project.getProjectBudget(),project.getDepartmentid(),project.getEmployeeid());
    }

    @Override
    public Optional<Project> findOne(int id) {
        List<Project> results = jdbcTemplate.query("SELECT projectid,projectName,projectBudget FROM projects WHERE project id = ?",
                                                    new ProjectRowMapper(),id );
       return results.stream().findFirst();
    }

    public static class ProjectRowMapper implements org.springframework.jdbc.core.RowMapper<Project>{

        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Project.builder()
                .projectId(rs.getInt("projectid"))
                .projectName(rs.getString("projectName"))
                .projectBudget(rs.getInt("projectBudget"))
                .departmentid(rs.getInt("departmentid"))
                .employeeid(rs.getInt("employeeid"))
                .build();
        }
        
    }
    
}   

