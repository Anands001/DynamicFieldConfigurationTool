package com.spring.dynamicfieldvalidation.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EntitiesListDTO {
    private List<EntityInfoDTO> entities= new ArrayList<>();
}
