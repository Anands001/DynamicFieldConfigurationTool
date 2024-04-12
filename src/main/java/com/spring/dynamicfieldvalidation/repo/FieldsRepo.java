package com.spring.dynamicfieldvalidation.repo;

import com.spring.dynamicfieldvalidation.entity.Fields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.spring.dynamicfieldvalidation.entity.MetaData;

@Repository
public interface FieldsRepo extends JpaRepository<Fields, String> {
    List<Fields> findByMetaDataId(MetaData metaData);

    Fields findByFieldNameAndMetaDataId(String fieldName, MetaData metaDataId);

}
