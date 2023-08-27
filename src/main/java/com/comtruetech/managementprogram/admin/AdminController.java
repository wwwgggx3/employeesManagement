package com.comtruetech.managementprogram.admin;

import com.comtruetech.managementprogram.admin.model.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService SERVICE;

    @Autowired
    public AdminController(AdminService service) {
        SERVICE = service;
    }

    //직원 정보 등록
    @Operation(summary = "직원 정보 등록")
    @PostMapping
    public int postEmployee(@RequestBody EmployeeInsDto dto) {

        return SERVICE.postEmployee(dto);
    }
    //직원 리스트 출력 (직원번호, 직급, 이름, 전화번호, 이메일)
    @Operation(summary = "직원 리스트 출력")
    @GetMapping
    public EmployeeList getEmloyees(@RequestParam(defaultValue = "1") int page,
                                    @RequestParam(defaultValue = "10") int row) {
        SelListDto dto = new SelListDto();
        dto.setRow(row);
        dto.setPage(page);
        return SERVICE.getEmloyees(dto);
    }

    //직원 검색 (각 필드별 검색)
    /*
    SerchDto의 type에 입력한 숫자에 따라 검색되도록 구현
    1 - employeeId(직원번호)
    2 - titleId직급)
    3 - 이름
    4 - 전화번호
    5 - 이메일
     */
    @Operation(summary = "직원 검색 (각 필드별 검색)", description = "SerchDto의 type에 입력한 숫자에 따라 검색되도록 구현<br>" +
            "    1 - employeeId(직원번호)<br>" +
            "    2 - titleId직급)<br>" +
            "    3 - 이름<br>" +
            "    4 - 전화번호<br>" +
            "    5 - 이메일")
    @PostMapping("/serch")
    public List<EmployeesVo> serchEmployees(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int row,
                                            @RequestBody SerchDto dto) {

        return SERVICE.serchEmployees(dto, page, row);
    }

    //직원 정보 수정
    @Operation(summary = "직원 정보 수정")
    @PutMapping
    public int putEmployee(@RequestBody EmployeeUpdDto dto) {
        return SERVICE.putEmployee(dto);
    }

    //직원 정보 삭제 (del_yn컬럼을 추가해 직원 정보를 DB에서 완전 삭제하지 않고 삭제한 직원 정보는 del_yn=1로 update하도록 구현)
    @Operation(summary = "직원 정보 삭제")
    @DeleteMapping
    public int delEmployee(@RequestParam int employeeId) {
        return SERVICE.delEmployee(employeeId);
    }

    
}
