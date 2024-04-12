package com.spring.dynamicfieldvalidation.service;

import com.spring.dynamicfieldvalidation.dto.EntityInfoDTO;
import com.spring.dynamicfieldvalidation.entity.MetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {
    @Autowired
    MetaDataService metaDataService;
    @Autowired
    FieldsService fieldsService;

    public void saveData(List<EntityInfoDTO> entityInfoDTOList){
        for(EntityInfoDTO entity : entityInfoDTOList){
//            metaDataService.save()
        }
    }
}
