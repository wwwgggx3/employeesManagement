package com.comtruetech.managementprogram.admin;

import com.comtruetech.managementprogram.admin.model.*;
import com.comtruetech.managementprogram.utils.EmailValidator;
import com.comtruetech.managementprogram.utils.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminMapper MAPPER;

    @Autowired
    public AdminService(AdminMapper mapper) {
        MAPPER = mapper;
    }

    public int postEmployee(EmployeeInsDto dto) {
        if(PhoneNumberValidator.PhoneNumberValidator(dto.getTel())==false) {
            return 101; //전화번호 유효성 검사 실패시 반환값
        }
        if(EmailValidator.emailValidator(dto.getEmail())==false) {
            return 102; //이메일 유효성 검사 실패시 반환값
        }
        return MAPPER.insEmployee(dto); //유효성 검사 통과시 실행될 로직
    }

    public EmployeeList getEmloyees(SelListDto dto) {
        int startIdx = (dto.getPage() - 1) * dto.getRow();
        dto.setStartIdx(startIdx);
        int maxProduct = MAPPER.EmployeesCount();

        PageDto pageDto = new PageDto(maxProduct, dto.getPage(), dto.getRow());

        return EmployeeList.builder()
                .employees(MAPPER.selEmployees(dto))
                .page(pageDto)
                .build();
    }

    public List<EmployeesVo> serchEmployees(SerchDto dto, int page, int row) {
        SerchDto2 dto2 = new SerchDto2();
        dto2.setCtnt(dto.getCtnt());
        dto2.setType(dto.getType());
        dto2.setPage(page);
        dto2.setRow(row);
        dto2.setStartIdx(0);
        List<EmployeesVo> list = MAPPER.serchEmployees(dto2);

        return list;
    }
    public int putEmployee(EmployeeUpdDto dto) {
        if(PhoneNumberValidator.PhoneNumberValidator(dto.getTel())==false) {
            return 101; //전화번호 유효성 검사 실패시 반환값
        }
        if(EmailValidator.emailValidator(dto.getEmail())==false) {
            return 102; //이메일 유효성 검사 실패시 반환값
        }
        return MAPPER.updEmployee(dto);
    }

    public int delEmployee(int employeeId) {
        return MAPPER.delEmployee(employeeId);
    }


    public int mailSend() {
//        MailSender.main();
        return 1;
    }

}
