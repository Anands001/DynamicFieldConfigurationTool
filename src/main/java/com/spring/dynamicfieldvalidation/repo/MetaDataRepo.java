package com.spring.dynamicfieldvalidation.repo;

import com.spring.dynamicfieldvalidation.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepo extends JpaRepository<MetaData, String> {
    MetaData findByEntityName(String e_name);
}
