package com.spring.dynamicfieldvalidation.dto;

import lombok.Data;

import java.util.List;

@Data
public class EntityInfoDTO {
    private String entityId;
    private String entityName;
    private List<FieldInfoDTO> fields;
}
