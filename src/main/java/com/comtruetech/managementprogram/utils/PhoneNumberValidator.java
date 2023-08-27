package com.comtruetech.managementprogram.utils;

import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static boolean PhoneNumberValidator(String number) {

        String pattern = "(\\d{3})-(\\d{3,4})-(\\d{4})"; // (2~3자리 숫자)-(3~4자리 숫자)-(4자리 숫자)

        if(Pattern.matches(pattern, number)) {
            return true;
        } return false;
    }
}
