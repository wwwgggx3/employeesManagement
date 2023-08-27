package com.comtruetech.managementprogram.admin.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class EmployeeList {
    private PageDto page;
    private List<EmployeesVo> employees;
}


