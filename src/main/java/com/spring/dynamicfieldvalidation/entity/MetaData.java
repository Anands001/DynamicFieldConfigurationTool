package com.spring.dynamicfieldvalidation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import lombok.ToString;

@Data
@Entity
@Table
public class MetaData {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    String entityId;
    String tableName;
    String entityName;
    String displayName;

    @ToString.Exclude
    @OneToMany(mappedBy = "metaDataId")
    List<Fields> fields;
}
