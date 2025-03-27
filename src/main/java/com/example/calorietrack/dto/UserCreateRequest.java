package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO для сознадния пользователя.
 */
@Data
public class UserCreateRequest {

    @NotNull
    @Schema(description = "имя пользователя", example = "Григорий")
    private String name;

    @NotNull
    @Email(message = "Некорректный формат email")
    @Schema(description = "почта пользователя", example = "Abricos@mail.ru")
    private String email;

    @Min(value = 0, message = "Возраст должен быть не менее 0")
    @Max(value = 150, message = "Возраст должен быть не более 150")
    @NotNull
    @Schema(description = "возраст пользователя", example = "30")
    private Integer age;

    @Min(value = 5, message = "Вес должен быть не менее 0")
    @Max(value = 1500, message = "Вес должен быть не более 1500")
    @NotNull
    @Schema(description = "вес пользователя", example = "88.5")
    private Float weight;

    @Min(value = 40, message = "Вес должен быть не менее 40")
    @Max(value = 300, message = "Вес должен быть не более 300")
    @NotNull
    @Schema(description = "рост пользователя", example = "180")
    private Integer growth;

    @NotNull
    @Schema(description = "цель пользователя (Похудение, Поддержание, Набор массы)", example = "(Loss, Maintenance, Gain)")
    private String purpose;
}
