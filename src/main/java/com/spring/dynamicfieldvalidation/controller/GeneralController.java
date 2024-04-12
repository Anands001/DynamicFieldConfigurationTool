package com.spring.dynamicfieldvalidation.controller;

import com.spring.dynamicfieldvalidation.dto.EntitiesListDTO;
import com.spring.dynamicfieldvalidation.dto.EntityInfoDTO;
import com.spring.dynamicfieldvalidation.dto.FieldInfoDTO;
import com.spring.dynamicfieldvalidation.service.FieldsService;
import com.spring.dynamicfieldvalidation.service.MetaDataService;
import com.spring.dynamicfieldvalidation.service.ValidationService;
import com.spring.dynamicfieldvalidation.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
public class GeneralController {
    @Autowired
    FieldsService fieldsService;
    @Autowired
    MetaDataService metaDataService;
    @Autowired
    WebClientService webClientService;
    @Autowired
    ValidationService validationService;

    @PostMapping("sendEntities")
    public String sendEntities(@RequestBody EntitiesListDTO entitiesListDTO) {
        System.out.println(entitiesListDTO);
        metaDataService.saveMetaData(entitiesListDTO.getEntities());
        return "Hello";
    }

    @GetMapping("getEntities")
    public List<EntityInfoDTO> getEntities() {
        EntitiesListDTO entitiesListDTO = webClientService.fetchData();
        System.out.println(entitiesListDTO);
        metaDataService.saveMetaData1(entitiesListDTO.getEntities());
        return entitiesListDTO.getEntities();
    }

    @GetMapping("getEntitiesFromDb")
    public List<EntityInfoDTO> getEntitiesFromDb() {
        EntitiesListDTO entitiesListDTO = webClientService.fetchData();
        System.out.println(entitiesListDTO);
        metaDataService.saveMetaData1(entitiesListDTO.getEntities());
        return metaDataService.getAllMetaData();
    }

    @PostMapping("setValidation")
    public ResponseEntity setValidation(@RequestBody FieldInfoDTO fieldInfoDTO){
        fieldsService.saveValidation(fieldInfoDTO);
        return ResponseEntity.ok(200);
    }

    @PostMapping("checkValidation")
    public ResponseEntity checkValidation(@RequestHeader String entityId,@RequestBody HashMap<String,String> data){
//        System.out.println(entityId);
//        System.out.println(data);
        List<String> response = validationService.checkValidation(entityId,data);
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}