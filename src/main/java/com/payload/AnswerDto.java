package com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    @NotNull(message = "text bo'sh bo'lmasin")
    private String text;
    private boolean is_correct;
    @NotNull(message = "user_id bo'sh bo'lmasin")
    private Long user_id;
    @NotNull(message = "task_id bo'sh bo'lmasin")
    private Long task_id;
}
