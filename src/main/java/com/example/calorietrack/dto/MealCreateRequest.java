package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * DTO для создания приема пищи
 */
@Data
public class MealCreateRequest {

    @NotNull
    @Schema(description = "Имя приема", example = "supper")
    private String name;


    @NotNull
    @Schema(description = "Время приема", example = "24-03-2025 14:30")
    private LocalDateTime dateTime;

    @NotNull
    @Schema(description = "ID пользователя", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    private String userId;

    @NotNull
    private LinkedList<PortionDto> portionList;
}
