package com.spring.dynamicfieldvalidation.service;

import com.spring.dynamicfieldvalidation.dto.FieldInfoDTO;
import com.spring.dynamicfieldvalidation.dto.FieldsDto;
import com.spring.dynamicfieldvalidation.entity.Fields;
import com.spring.dynamicfieldvalidation.entity.MetaData;
import com.spring.dynamicfieldvalidation.entity.Validation;
import com.spring.dynamicfieldvalidation.repo.FieldsRepo;
import com.spring.dynamicfieldvalidation.repo.ValidationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldsService {
    @Autowired
    FieldsRepo fieldsRepo;
    @Autowired
    ValidationRepo validationRepo;
    public Fields save(FieldsDto field){
        Fields fields1 = new Fields();
        fields1.setFieldName(field.getFieldName());
        fields1.setFieldType(field.getFieldType());
        for (Validation validation: field.getValidationsList()){
            validation.setField(fields1);
            validationRepo.save(validation);
        }
        return fields1;
    }
    public void saveFields(List<FieldInfoDTO> fields, MetaData metaData) {
        for (FieldInfoDTO field : fields) {
            Fields fields1 = new Fields();
            fields1.setFieldName(field.getFieldName());
            fields1.setFieldType(field.getFieldType());
            fields1.setMetaDataId(metaData);
            fieldsRepo.save(fields1);
        }
    }
    public Fields getFields(String id){
        Fields fields = null;
        if(fieldsRepo.findById(id).isPresent())
            fields = fieldsRepo.findById(id).get();
        return fields;
    }
    public void deleteFields(String id){
        fieldsRepo.deleteById(id);
    }
    public Fields updateFields(Fields fields){
        Fields fields1 = fieldsRepo.save(fields);
        return fields1;
    }
    public List<Fields> getFieldsByMetaDataId(MetaData metaData){
        return fieldsRepo.findByMetaDataId(metaData);
    }

    public void saveValidation(FieldInfoDTO fieldInfoDTO){
        System.out.println(fieldInfoDTO);
        Fields fields = fieldsRepo.findById(fieldInfoDTO.getFieldId()).get();
        validationRepo.deleteByFieldId(fields.getId());
        fields.setDropDownId(fieldInfoDTO.getDropDownId());
        fields.setValidations(fieldInfoDTO.getValidations().stream().map(validation -> {
            validation.setField(fields);
            return validation;
        }).collect(Collectors.toList()));
        System.out.println(fields.getValidations());
        fieldsRepo.save(fields);
    }
}
