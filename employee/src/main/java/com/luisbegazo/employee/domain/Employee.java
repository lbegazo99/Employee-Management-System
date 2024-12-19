package com.luisbegazo.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {
    private Long employeeId;
    private String name;
    private String dob;
    private char gender;
    private String number;
    private String role;
    private int salary;
    private boolean isManager;
}
