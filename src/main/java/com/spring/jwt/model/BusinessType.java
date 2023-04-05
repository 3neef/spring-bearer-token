package com.spring.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "wathiq_business_types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessType {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Integer businessId;

    private String name;

    private String nameEn;

    public BusinessType(Integer id, String name, String nameEn) {
        this.businessId = id;
        this.name = name;
        this.nameEn = nameEn;
    }
}
