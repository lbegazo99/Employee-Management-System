package com.luisbegazo.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Department {
    private int departmentid;
    private String departmentName;
    private Long managerid;
}
