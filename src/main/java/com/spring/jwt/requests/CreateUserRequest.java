package com.spring.jwt.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CreateUserRequest {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
