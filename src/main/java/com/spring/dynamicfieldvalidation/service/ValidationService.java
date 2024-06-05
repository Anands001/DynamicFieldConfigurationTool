package com.spring.dynamicfieldvalidation.service;

import com.spring.dynamicfieldvalidation.entity.MetaData;
import com.spring.dynamicfieldvalidation.entity.Validation;
import com.spring.dynamicfieldvalidation.repo.ValidationRepo;
import com.spring.dynamicfieldvalidation.service.validations.ValidationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;

@Service
public class ValidationService {
    @Autowired
    ValidationRepo validationRepo;
    @Autowired
    FieldsService fieldsService;
    @Autowired
    ValidationServices validationServices;

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    DropDownService dropDownService;

    public Validation save(Validation validation){
        Validation validation1 = validationRepo.save(validation);
        return validation1;
    }
    public Validation getValidation(String id){
        Validation validation = null;
        if(validationRepo.findById(id).isPresent())
            validation = validationRepo.findById(id).get();
        return validation;
    }
    public void deleteValidation(String id){
        validationRepo.deleteById(id);
    }
    public Validation updateValidation(Validation validation){
        Validation validation1 = validationRepo.save(validation);
        return validation1;
    }
    public List<String> checkValidation(String id, HashMap data){
        List<String> errors = new ArrayList<>();
        MetaData metaData = metaDataService.getMetaData(id);
        metaData.setEntityId(id);
        fieldsService.getFieldsByMetaDataId(metaData).forEach(fields -> {
            if(fields.getValidations() != null){
                System.out.println("Fields: " + fields.getFieldName() + " Validations: " + fields.getValidations());
                fields.getValidations().forEach(validation -> {
                    if(validation.getValidationType().equals("required")){
                        if(!validationServices.required((String) data.get(fields.getFieldName()))){
                            errors.add("Field " + fields.getFieldName() + " is required");
                        }
                    }
                    if(validation.getValidationType().equals("min_value")){
                        if(data.get(fields.getFieldName()) != null){
                            if(Integer.parseInt(data.get(fields.getFieldName()).toString()) < Integer.parseInt(validation.getValidationValue())){
                                errors.add(fields.getFieldName() + " should be greater than " + validation.getValidationValue());
                            }
                        }
                    }
                    if(validation.getValidationType().equals("max_value")){
                        if(data.get(fields.getFieldName()) != null){
                            if(Integer.parseInt(data.get(fields.getFieldName()).toString()) > Integer.parseInt(validation.getValidationValue())){
                                errors.add(fields.getFieldName() + " should be less than " + validation.getValidationValue());
                            }
                        }
                    }
                    if(validation.getValidationType().equals("min_length")){
                        if(data.get(fields.getFieldName()) != null){
                            if(!validationServices.minLength((String)data.get(fields.getFieldName()),Integer.parseInt(validation.getValidationValue()))){
                                errors.add(fields.getFieldName() + " Min length:  " + validation.getValidationValue());
                            }
                        }
                    }
                    if(validation.getValidationType().equals("max_length")){
                        if(data.get(fields.getFieldName()) != null){
                            if(!validationServices.maxLength((String)data.get(fields.getFieldName()),Integer.parseInt(validation.getValidationValue()))){
                                errors.add(fields.getFieldName() + " Max length: " + validation.getValidationValue());
                            }
                        }
                    }
                    if(validation.getValidationType().equals("regex")){
                        if(data.get(fields.getFieldName()) != null && !validation.getValidationValue().isEmpty()){
                            if(!validationServices.customRegex((String)data.get(fields.getFieldName()),validation.getValidationValue())){
                                errors.add(fields.getFieldName() + " does not match " + validation.getValidationValue());
                            }
                        }
                    }
//                    if(validation.getValidationType().equals("dropdown")){
//                        if(data.get(fields.getFieldName()) != null){
//                            String dropdownValue = data.get(fields.getFieldName()).toString();
//                            HashMap<String, Object> dropdown = new Gson().fromJson(validation.getValidationValue(), HashMap.class);
//                            System.out.println("Dropdown value: " + dropdown);
//                            if(dropdown!= null && !dropdown.containsKey(dropdownValue)){
//                                errors.add("Dropdown value " + dropdownValue + " does not match any dropdown key");
//                            }
//                        }
//                    }

                });

            }
            if(fields.getDropDownId() != null){
                if(data.get(fields.getFieldName()) != null){
                    String dropdownValue = data.get(fields.getFieldName()).toString();
                    System.out.println("Dropdown value: " + dropdownValue);
                    System.out.println("Dropdown id: " + fields.getDropDownId());
                    System.out.println("Dropdown db value: " + dropDownService.getDropDownById(fields.getDropDownId()));
                    if(dropDownService.getDropDownById(fields.getDropDownId()) != null) {
                        HashMap dropdown = new Gson().fromJson(dropDownService.getDropDownById(fields.getDropDownId()), HashMap.class);
                        System.out.println("Dropdown value: " + dropdown);
                        if (dropdown != null && !dropdown.containsKey(dropdownValue)) {
                            errors.add("Dropdown value " + dropdownValue + " does not match any dropdown key");
                        }
                    }
                }
            }
        });

        return errors;
    }

}
