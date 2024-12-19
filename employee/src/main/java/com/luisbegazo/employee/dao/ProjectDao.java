package com.luisbegazo.employee.dao;

import java.util.Optional;

import com.luisbegazo.employee.domain.Project;

public interface ProjectDao {
    void create(Project project);

    Optional<Project> findOne(int id);
}
