package com.spring.dynamicfieldvalidation.service.validations;

import java.util.List;

public interface IValidationServices {
    boolean required(String value);

    boolean minLength(String value, int length);

    boolean maxLength(String value, int length);

    boolean email(String value);

    boolean isValidEmail(String value);

    boolean isEmailDomain(String value, String domain);

    boolean isEmailLength(String value, int length);

    boolean isInList(String value, List<String> list);

    boolean phone(String value);

    boolean date(String value);

    boolean number(String value);

    boolean decimal(String value);

    boolean isAlphanumeric(String value);

    boolean isAlpha(String value);

    boolean isNumeric(String value);

    boolean isLowercase(String value);

    boolean isUppercase(String value);

    boolean customRegex(String value, String pattern);

    boolean isBoolean(String value);

    boolean isValidPassword(String value);

    boolean isPasswordLength(String value, int length);

    boolean hasUppercase(String value);

    boolean hasLowercase(String value);

    boolean hasDigit(String value);

    boolean hasSpecialChar(String value);

    boolean isDouble(String value);

    boolean isURL(String value);

    boolean isIPv4(String value);

    boolean isIPv6(String value);

    boolean precision(String value, int precision);

    boolean isInteger(String value);

    boolean intRange(String value, int min, int max);

    boolean intLessThan(String value, int limit);

    boolean intGreaterThan(String value, int limit);

    boolean dateRange(String value, String startDate, String endDate);

    boolean dateAfter(String value, String afterDate);

    boolean dateBefore(String value, String beforeDate);

    boolean isDateInFormat(String value, String format);
}
