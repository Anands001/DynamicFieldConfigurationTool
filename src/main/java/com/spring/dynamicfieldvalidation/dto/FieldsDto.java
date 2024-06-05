package com.spring.dynamicfieldvalidation.dto;

import com.spring.dynamicfieldvalidation.entity.Validation;
import lombok.Data;

import java.util.List;

@Data
public class FieldsDto {
    private String fieldName;
    private String fieldType;
    private String dropDownId;
    List<Validation> validationsList;
}
