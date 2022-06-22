package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    @NotNull(message = "name bo'sh bo'lmasin")
    private String name;
}
