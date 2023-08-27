package com.comtruetech.managementprogram.admin;

import com.comtruetech.managementprogram.admin.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    int insEmployee(EmployeeInsDto dto);
    int updEmployee(EmployeeUpdDto dto);
    int delEmployee(int EmployeeId);

    List<EmployeesVo> selEmployees(SelListDto dto);
    int EmployeesCount();

    List<EmployeesVo> serchEmployees(SerchDto2 dto);
//    List<EmployeesVo> serchEmployees(SerchDto dto1);
}
