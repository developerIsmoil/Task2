package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    @NotNull(message = "name bo'sh bo'lmasin")
    private String name;
    @NotNull(message = "text bo'sh bo'lmasin")
    private String text;
    @NotNull(message = "solution bo'sh bo'lmasin")
    private String solution;
    @NotNull(message = "hint bo'sh bo'lmasin")
    private String hint;
    @NotNull(message = "method bo'sh bo'lmasin")
    private String method;
    private boolean has_star;
    @NotNull(message = "lenguage_id bo'sh bo'lmasin")
    private Long lenguage_id;
}
