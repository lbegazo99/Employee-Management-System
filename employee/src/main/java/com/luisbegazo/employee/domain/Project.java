package com.luisbegazo.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Project {
    private int projectId;
    private String projectName;
    private int projectBudget;
    private int departmentid;
    private int employeeid;
}
