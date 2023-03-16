package com.spring.jwt.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CreateUserRequest {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String password;
}
