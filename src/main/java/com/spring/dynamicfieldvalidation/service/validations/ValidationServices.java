package com.spring.dynamicfieldvalidation.service.validations;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This class provides various methods for validating input data.
 */
@Service
public class ValidationServices implements IValidationServices {

    /**
     * Checks if a string is not null and not empty.
     *
     * @param value The string to check.
     * @return true if the string is not null and not empty, false otherwise.
     */
    @Override
    public boolean required(String value){
        return value != null;
    }

    /**
     * Checks if a string has a minimum length.
     *
     * @param value The string to check.
     * @param length The minimum length.
     * @return true if the string has a length greater than or equal to the specified length, false otherwise.
     */
    @Override
    public boolean minLength(String value, int length){
        return value.length() >= length;
    }

    /**
     * Checks if a string has a maximum length.
     *
     * @param value The string to check.
     * @param length The maximum length.
     * @return true if the string has a length less than or equal to the specified length, false otherwise.
     */
    @Override
    public boolean maxLength(String value, int length){
        return value.length() <= length;
    }

    /**
     * Checks if a string is a valid email address.
     *
     * @param value The string to check.
     * @return true if the string is a valid email address, false otherwise.
     */
    @Override
    public boolean email(String value){
        return value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    /**
     * Checks if a string is a valid email address.
     *
     * @param value The string to check.
     * @return true if the string is a valid email address, false otherwise.
     */
    @Override
    public boolean isValidEmail(String value){
        return value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    /**
     * Checks if the domain of an email address matches a specific domain.
     *
     * @param value The email address to check.
     * @param domain The domain to match.
     * @return true if the domain of the email address matches the specified domain, false otherwise.
     */
    @Override
    public boolean isEmailDomain(String value, String domain){
        return value.toLowerCase().endsWith("@" + domain.toLowerCase());
    }

    /**
     * Checks if the length of an email address is less than or equal to a specific length.
     *
     * @param value The email address to check.
     * @param length The maximum length.
     * @return true if the length of the email address is less than or equal to the specified length, false otherwise.
     */
    @Override
    public boolean isEmailLength(String value, int length){
        return value.length() <= length;
    }

    /**
     * Checks if a string is in a specific list of strings.
     *
     * @param value The string to check.
     * @param list The list of strings.
     * @return true if the string is in the list, false otherwise.
     */
    @Override
    public boolean isInList(String value, List<String> list){
        return list.contains(value);
    }

    /**
     * Checks if a string is a valid phone number.
     *
     * @param value The string to check.
     * @return true if the string is a valid phone number, false otherwise.
     */
    @Override
    public boolean phone(String value){
        return value.matches("^[0-9]{10}$");
    }

    /**
     * Checks if a string is a valid date in the format dd/MM/yyyy.
     *
     * @param value The string to check.
     * @return true if the string is a valid date, false otherwise.
     */
    @Override
    public boolean date(String value){
        return value.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}$");
    }

    /**
     * Checks if a string is a valid number.
     *
     * @param value The string to check.
     * @return true if the string is a valid number, false otherwise.
     */
    @Override
    public boolean number(String value){
        return value.matches("^[0-9]+$");
    }

    /**
     * Checks if a string is a valid decimal number.
     *
     * @param value The string to check.
     * @return true if the string is a valid decimal number, false otherwise.
     */
    @Override
    public boolean decimal(String value){
        return value.matches("^[0-9]+(\\.[0-9]+)?$");
    }

    /**
     * Checks if a string contains only alphanumeric characters.
     *
     * @param value The string to check.
     * @return true if the string contains only alphanumeric characters, false otherwise.
     */
    @Override
    public boolean isAlphanumeric(String value){
        return value.matches("^[a-zA-Z0-9]+$");
    }

    /**
     * Checks if a string contains only alphabetic characters.
     *
     * @param value The string to check.
     * @return true if the string contains only alphabetic characters, false otherwise.
     */
    @Override
    public boolean isAlpha(String value){
        return value.matches("^[a-zA-Z]+$");
    }

    /**
     * Checks if a string contains only numeric characters.
     *
     * @param value The string to check.
     * @return true if the string contains only numeric characters, false otherwise.
     */
    @Override
    public boolean isNumeric(String value){
        return value.matches("^[0-9]+$");
    }

    /**
     * Checks if a string contains only lowercase characters.
     *
     * @param value The string to check.
     * @return true if the string contains only lowercase characters, false otherwise.
     */
    @Override
    public boolean isLowercase(String value){
        return value.equals(value.toLowerCase());
    }

    /**
     * Checks if a string contains only uppercase characters.
     *
     * @param value The string to check.
     * @return true if the string contains only uppercase characters, false otherwise.
     */
    @Override
    public boolean isUppercase(String value){
        return value.equals(value.toUpperCase());
    }

    /**
     * Checks if a string matches a specific regular expression pattern.
     *
     * @param value The string to check.
     * @param pattern The regular expression pattern.
     * @return true if the string matches the pattern, false otherwise.
     */
    @Override
    public boolean customRegex(String value, String pattern){
        return value.matches(pattern);
    }

    /**
     * Checks if a string can be parsed into a boolean.
     *
     * @param value The string to check.
     * @return true if the string can be parsed into a boolean, false otherwise.
     */
    @Override
    public boolean isBoolean(String value){
        return "true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value);
    }

    /**
     * Checks if a string is a valid password. A valid password in this case is defined as a string that contains at least one uppercase letter, one lowercase letter, one digit, one special character and has a length of at least 8.
     *
     * @param value The string to check.
     * @return true if the string is a valid password, false otherwise.
     */
    @Override
    public boolean isValidPassword(String value){
        return value.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

    /**
     * Checks if the length of a password is greater than or equal to a specific length.
     *
     * @param value The password to check.
     * @param length The minimum length.
     * @return true if the length of the password is greater than or equal to the specified length, false otherwise.
     */
    @Override
    public boolean isPasswordLength(String value, int length){
        return value.length() >= length;
    }

    /**
     * Checks if a password contains at least one uppercase letter.
     *
     * @param value The password to check.
     * @return true if the password contains at least one uppercase letter, false otherwise.
     */
    @Override
    public boolean hasUppercase(String value){
        return value.matches(".*[A-Z].*");
    }

    /**
     * Checks if a password contains at least one lowercase letter.
     *
     * @param value The password to check.
     * @return true if the password contains at least one lowercase letter, false otherwise.
     */
    @Override
    public boolean hasLowercase(String value){
        return value.matches(".*[a-z].*");
    }

    /**
     * Checks if a password contains at least one digit.
     *
     * @param value The password to check.
     * @return true if the password contains at least one digit, false otherwise.
     */
    @Override
    public boolean hasDigit(String value){
        return value.matches(".*[0-9].*");
    }

    /**
     * Checks if a password contains at least one special character.
     *
     * @param value The password to check.
     * @return true if the password contains at least one special character, false otherwise.
     */
    @Override
    public boolean hasSpecialChar(String value){
        return value.matches(".*[@#$%^&+=].*");
    }

    /**
     * Checks if a string can be parsed into a double.
     *
     * @param value The string to check.
     * @return true if the string can be parsed into a double, false otherwise.
     */
    @Override
    public boolean isDouble(String value){
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a string is a valid URL.
     *
     * @param value The string to check.
     * @return true if the string is a valid URL, false otherwise.
     */
    @Override
    public boolean isURL(String value){
        try {
            new java.net.URL(value);
            return true;
        } catch (java.net.MalformedURLException e) {
            return false;
        }
    }

    /**
     * Checks if a string is a valid IPv4 address.
     *
     * @param value The string to check.
     * @return true if the string is a valid IPv4 address, false otherwise.
     */
    @Override
    public boolean isIPv4(String value){
        return value.matches("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    }

    /**
     * Checks if a string is a valid IPv6 address.
     *
     * @param value The string to check.
     * @return true if the string is a valid IPv6 address, false otherwise.
     */
    @Override
    public boolean isIPv6(String value){
        return value.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    }

    /**
     * Checks if a string is a valid decimal number with a specific precision.
     *
     * @param value The string to check.
     * @param precision The precision.
     * @return true if the string is a valid decimal number with the specified precision, false otherwise.
     */
    @Override
    public boolean precision(String value, int precision){
        String pattern = "^\\d+\\.\\d{" + precision + "}$";
        return value.matches(pattern);
    }

    /**
     * Checks if a string can be parsed into an integer.
     *
     * @param value The string to check.
     * @return true if the string can be parsed into an integer, false otherwise.
     */
    @Override
    public boolean isInteger(String value){
        return value.matches("^-?\\d+$");
    }

    /**
     * Checks if a numeric string is within a specific range.
     *
     * @param value The string to check.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return true if the numeric string is within the range, false otherwise.
     */
    @Override
    public boolean intRange(String value, int min, int max){
        try {
            int intValue = Integer.parseInt(value);
            return intValue >= min && intValue <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a numeric string is less than a specific limit.
     *
     * @param value The string to check.
     * @param limit The limit.
     * @return true if the numeric string is less than the limit, false otherwise.
     */
    @Override
    public boolean intLessThan(String value, int limit){
        try {
            int intValue = Integer.parseInt(value);
            return intValue < limit;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a numeric string is greater than a specific limit.
     *
     * @param value The string to check.
     * @param limit The limit.
     * @return true if the numeric string is greater than the limit, false otherwise.
     */
    @Override
    public boolean intGreaterThan(String value, int limit){
        try {
            int intValue = Integer.parseInt(value);
            return intValue > limit;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    /**
     * Checks if a date string is within a specific range.
     *
     * @param value The date string to check.
     * @param startDate The start date.
     * @param endDate The end date.
     * @return true if the date string is within the range, false otherwise.
     */
    @Override
    public boolean dateRange(String value, String startDate, String endDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            Date dateValue = sdf.parse(value);
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            return dateValue.after(start) && dateValue.before(end);
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Checks if a date string is after a specific date.
     *
     * @param value The date string to check.
     * @param afterDate The date to compare with.
     * @return true if the date string is after the specified date, false otherwise.
     */
    @Override
    public boolean dateAfter(String value, String afterDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            Date dateValue = sdf.parse(value);
            Date after = sdf.parse(afterDate);
            return dateValue.after(after);
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Checks if a date string is before a specific date.
     *
     * @param value The date string to check.
     * @param beforeDate The date to compare with.
     * @return true if the date string is before the specified date, false otherwise.
     */
    @Override
    public boolean dateBefore(String value, String beforeDate){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            Date dateValue = sdf.parse(value);
            Date before = sdf.parse(beforeDate);
            return dateValue.before(before);
        } catch (ParseException e) {
            return false;
        }
    }
    /**
     * Checks if a string is a valid date in the provided format.
     *
     * @param value The date string to check.
     * @param format The date format to be used for validation.
     * @return true if the string is a valid date in the provided format, false otherwise.
     */
    @Override
    public boolean isDateInFormat(String value, String format){
        try {
            new SimpleDateFormat(format).parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

