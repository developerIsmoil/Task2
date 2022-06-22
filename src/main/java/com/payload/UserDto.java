package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "email bo'sh bo'lmasin")
    private String email;
    @NotNull(message = "password bo'sh bo'lmasin")
    private String password;
}
