package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO с информацией о блюде
 */
@Data
public class DishInfoResponse {

    @NotNull
    @Schema(description = "Id блюда", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    private String dishId;

    @NotNull
    @Schema(description = "Имя блюда", example = "Стейк")
    private String name;

    @NotNull
    @Schema(description = "Количество каллорий в 1 порции", example = "450")
    private Integer calorie;

    @NotNull
    @Schema(description = "Белки", example = "16.8")
    private Float proteins;

    @NotNull
    @Schema(description = "Жиры", example = "15.0")
    private Float fats;

    @NotNull
    @Schema(description = "Углеводы", example = "20.5")
    private Float carbohydrates;
}
