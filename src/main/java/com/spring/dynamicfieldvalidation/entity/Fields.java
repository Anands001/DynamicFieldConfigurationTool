package com.spring.dynamicfieldvalidation.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import lombok.ToString;

@Table
@Data
@Entity
public class Fields {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    String id;
    String fieldName;
    String displayName;
    String fieldType;
    @ToString.Exclude
    @ManyToOne
            @JoinColumn(referencedColumnName = "id")
    MetaData metaDataId;
    String systemName;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "field")
    List<Validation> validations;

    Boolean isRequired = false;
    Boolean isEmail = false;
    Boolean isPhone = false;

}
