package com.spring.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "wathiq_locations")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long LocId;

    private String name;

    private String nameEn;

    public Location(long id, String name, String nameEn) {
        this.LocId = id;
        this.name = name;
        this.nameEn = nameEn;
    }
}
