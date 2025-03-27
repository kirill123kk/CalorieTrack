package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO для создания блюда
 */
@Data
public class DishCreateRequest {

    @NotNull
    @Schema(description = "Имя блюда", example = "Стейк")
    private String name;

    @Min(value = 0, message = "Количество калорий должно быть не менее 0")
    @NotNull
    @Schema(description = "Количество каллорий в 1 порции", example = "450")
    private Integer calorie;

    @Min(value = 0, message = "Количество белков должно быть не менее 0")
    @NotNull
    @Schema(description = "Белки", example = "16.8")
    private Float proteins;

    @Min(value = 0, message = "Количество белков должно быть не менее 0")
    @NotNull
    @Schema(description = "Жиры", example = "15.0")
    private Float fats;

    @Min(value = 0, message = "Количество углеводов должно быть не менее 0")
    @NotNull
    @Schema(description = "Углеводы", example = "20.5")
    private Float carbohydrates;
}
