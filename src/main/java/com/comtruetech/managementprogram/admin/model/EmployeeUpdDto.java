package com.comtruetech.managementprogram.admin.model;

import lombok.Data;

@Data
public class EmployeeUpdDto {
    private int employeeId;
    private int titleId;
    private String nm;
    private String tel;
    private String email;
}
