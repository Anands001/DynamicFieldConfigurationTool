package com.spring.dynamicfieldvalidation.repo;

import com.spring.dynamicfieldvalidation.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.dynamicfieldvalidation.entity.Fields;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ValidationRepo extends JpaRepository<Validation, String> {
    @Transactional
    @Modifying
    @Query(value = "delete from Validation v where v.field_id = ?1",nativeQuery = true)
    public void deleteByFieldId(String field);
}
