package com.luisbegazo.employee;

import com.luisbegazo.employee.domain.Department;
import com.luisbegazo.employee.domain.Employee;

public final class TestDataUtil {
    private TestDataUtil(){

    }

    public static Employee createEmployee() {
        return Employee.builder()
            .employeeId(1L)
            .name("Luis Begazo")
            .dob("10/14/1999")
            .gender('m')
            .number("929-490-5016")
            .role("senior software engineer")
            .salary(140000)
            .isManager(true)
            .build();
    }


    public static Employee createEmployeeB(){
        return Employee.builder()
            .employeeId(2L)
            .name("John Smith")
            .dob("8/31/2001")
            .gender('m')
            .number("347-652-3636")
            .role("principle engineer")
            .salary(160000)
            .isManager(true)
            .build();
    }

    public static Employee createEmployeeC(){
        return Employee.builder()
            .employeeId(3L)
            .name("Greg Jones")
            .dob("9/21/2003")
            .gender('m')
            .number("347-785-4531")
            .role("Junior software engineer")
            .salary(90000)
            .isManager(false)
            .build();
    }

    public static Department createDepartment(){
        return Department.builder()
                .departmentid(1)
                .departmentName("Engineering")
                .managerid(1L)
                .build();
    }
}
