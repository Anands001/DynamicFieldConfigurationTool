package com.spring.dynamicfieldvalidation.dto;

import com.spring.dynamicfieldvalidation.entity.Validation;
import lombok.Data;

import java.util.List;

@Data
public class FieldInfoDTO {
    private String fieldId;
    private String fieldName;
    private String fieldType;
    private String dropDownId;
    private List<Validation> validations;
}
