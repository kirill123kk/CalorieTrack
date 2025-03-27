package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO с информацией о приеме пищи.
 */
@Data
public class MealInfoResponse {
    @NotNull
    @Schema(description = "индентификатор приема", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    private String mealId;
    @NotNull
    @Schema(description = "Имя приема", example = "supper")
    private String name;

    @NotNull
    @Schema(description = "Время приема", example = "24-03-2025 14:30")
    private LocalDateTime dateTime;


}
