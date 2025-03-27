package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO показывающая колическво порций блюда
 */
@Data
public class PortionDto {

    @NotNull
    @Schema(description = "индентификатор блюда", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    String dishId;

    @NotNull
    @Min(value = 0, message = "Количество порций должно быть не менее 0")
    @Schema(description = "Порция", example = "1.5")
    Float quantity;
}
