package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {
    @NotNull(message = "text bo'sh bo'lmasin")
    private String text;
    @NotNull(message = "task_id bo'sh bo'lmasin")
    private Long task_id;
}
