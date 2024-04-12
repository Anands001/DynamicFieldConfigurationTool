package com.spring.dynamicfieldvalidation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table
public class Validation {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    String id = "";
    String validationType = "";
    String validationValue = "";
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
            @JsonIgnore
    Fields field;
}
