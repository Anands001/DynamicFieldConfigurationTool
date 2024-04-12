package com.spring.dynamicfieldvalidation.controller;

import com.spring.dynamicfieldvalidation.dto.FieldInfoDTO;
import com.spring.dynamicfieldvalidation.dto.FieldsDto;
import com.spring.dynamicfieldvalidation.entity.Fields;
import com.spring.dynamicfieldvalidation.service.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class FieldsController {
    @Autowired
    FieldsService fieldsService;
    @PostMapping(value = "saveField")
    public ResponseEntity<?> saveField(@RequestBody FieldsDto fieldsDto){
        fieldsService.save(fieldsDto);

        return ResponseEntity.ok(200);
    }
//    @PostMapping(value = "/saveFields",produces = "application/json")
//    public ResponseEntity<?> saveFields(@RequestBody List<FieldInfoDTO> fieldInfoDTO){
//        fieldsService.saveFields(fieldInfoDTO);
//        return ResponseEntity.ok(200);
//    }
    @GetMapping(value = "/getFields",produces = "application/json")
    public ResponseEntity<?> getFields(@RequestParam String id){
        Fields response = fieldsService.getFields(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public String printHello() {
        System.out.println("Hello World!");
        return "Hello";
    }
}
