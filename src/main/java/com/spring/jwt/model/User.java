package com.spring.jwt.model;

import jakarta.persistence.*;
import lombok.*;



@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String  password;
}
