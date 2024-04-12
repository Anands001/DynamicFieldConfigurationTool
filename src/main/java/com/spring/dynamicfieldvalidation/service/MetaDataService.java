package com.spring.dynamicfieldvalidation.service;

import com.spring.dynamicfieldvalidation.dto.EntitiesListDTO;
import com.spring.dynamicfieldvalidation.dto.EntityInfoDTO;
import com.spring.dynamicfieldvalidation.dto.FieldInfoDTO;
import com.spring.dynamicfieldvalidation.dto.ValidationDTO;
import com.spring.dynamicfieldvalidation.entity.Fields;
import com.spring.dynamicfieldvalidation.entity.MetaData;
import com.spring.dynamicfieldvalidation.entity.Validation;
import com.spring.dynamicfieldvalidation.repo.FieldsRepo;
import com.spring.dynamicfieldvalidation.repo.MetaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MetaDataService {
    @Autowired
    MetaDataRepo metaDataRepo;
    @Autowired
    FieldsService fieldsService;

    @Autowired
    FieldsRepo fieldsRepo;

    public MetaData save(MetaData metaData){
        MetaData metaData1 = metaDataRepo.save(metaData);
        return metaData1;
    }
    public void saveMetaData(List<EntityInfoDTO> metaData) {
        for (EntityInfoDTO entity : metaData) {
            MetaData metaData2;
            if((metaData2 = metaDataRepo.findByEntityName(entity.getEntityName()))!=null){
                entity.getFields().forEach(fieldsInfo -> {
                    Fields fields = new Fields();
                    fields.setFieldName(fieldsInfo.getFieldName());
                    fields.setMetaDataId(metaData2);
                    fields.setFieldType(fieldsInfo.getFieldType());
                    Fields existingField = fieldsRepo.findByFieldNameAndMetaDataId(fields.getFieldName(),metaData2);
                        if (existingField == null) {
                            // If the field doesn't exist, insert it into the table
                            fieldsRepo.save(fields);
//                            System.out.println("Inserted field: " + fields.getFieldName());
                        }
                    }
                );
            }else {
                MetaData metaData1 = new MetaData();
                String entityName = entity.getEntityName();
                String entityId = entity.getEntityId();
                metaData1.setEntityName(entityName);
                metaData1.setEntityId(entityId);
                metaDataRepo.save(metaData1);
                fieldsService.saveFields(entity.getFields(), metaData1);
            }
        }
    }
    public void saveMetaData1(List<EntityInfoDTO> metaData) {
        for (EntityInfoDTO entity : metaData) {
            MetaData metaData2;
            if((metaData2 = metaDataRepo.findByEntityName(entity.getEntityName()))!=null){
                List<FieldInfoDTO> clientFields = entity.getFields();
                List<Fields> dbFields = fieldsService.getFieldsByMetaDataId(metaData2);
                clientFields.stream().filter(clientField -> dbFields.stream().noneMatch(dbField -> dbField.getFieldName().equals(clientField.getFieldName()))).forEach(clientField -> {
                    Fields fields = new Fields();
                    fields.setFieldName(clientField.getFieldName());
                    fields.setMetaDataId(metaData2);
                    fields.setFieldType(clientField.getFieldType());
                    fieldsRepo.save(fields);
                });
            }else {
                MetaData metaData1 = new MetaData();
                String entityName = entity.getEntityName();
                String entityId = entity.getEntityId();
                metaData1.setEntityName(entityName);
                metaData1.setEntityId(entityId);
                metaDataRepo.save(metaData1);
                fieldsService.saveFields(entity.getFields(), metaData1);
            }
        }
    }
    public MetaData getMetaData(String id){
        MetaData metaData = null;
        if(metaDataRepo.findById(id).isPresent())
            metaData = metaDataRepo.findById(id).get();
        return metaData;
    }
    public void deleteMetaData(String id){
        metaDataRepo.deleteById(id);
    }
    public MetaData updateMetaData(MetaData metaData){
        MetaData metaData1 = metaDataRepo.save(metaData);
        return metaData1;
    }

        public List<EntityInfoDTO> getAllMetaData() {
            EntitiesListDTO entitiesListDTO = new EntitiesListDTO();

            metaDataRepo.findAll().forEach(entity -> {
                EntityInfoDTO entityInfoDTO = new EntityInfoDTO();
                entityInfoDTO.setEntityId(entity.getId());
                entityInfoDTO.setEntityName(entity.getEntityName());
                entityInfoDTO.setFields(new ArrayList<FieldInfoDTO>());
                List<Fields> fields = fieldsService.getFieldsByMetaDataId(entity);
                fields.forEach(field -> {
                    FieldInfoDTO fieldInfoDTO = new FieldInfoDTO();
                    fieldInfoDTO.setFieldId(field.getId());
                    fieldInfoDTO.setFieldName(field.getFieldName());
                    fieldInfoDTO.setFieldType(field.getFieldType());
    //              Set  Validation
//                    List<ValidationDTO> validationDTOList = new ArrayList<>();
//                    ValidationDTO validationDTO = new ValidationDTO();
//
//                    validationDTO.setValidationType("isRequired");
//                    validationDTO.setValidationValue(String.valueOf(field.getIsRequired()));
//                    validationDTOList.add(validationDTO);
    //                System.out.println(field.getId()+" "+field.getValidations());
                    fieldInfoDTO.setValidations(field.getValidations());

//                    System.out.println(fieldInfoDTO.getValidations());
                    entityInfoDTO.getFields().add(fieldInfoDTO);
                });
                entitiesListDTO.getEntities().add(entityInfoDTO);
            });
            return entitiesListDTO.getEntities();
        }
}
