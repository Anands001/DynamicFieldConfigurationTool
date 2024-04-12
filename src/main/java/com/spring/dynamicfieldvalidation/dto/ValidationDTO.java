package com.spring.dynamicfieldvalidation.dto;

import lombok.Data;

@Data
public class ValidationDTO {
    String validationId;
    String validationType;
    String validationValue;
}
