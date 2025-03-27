package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * DTO с отчетом о дневном питании
 */
@Data
public class DailyReportRequest {

    @NotNull
    @Schema(description = "индентификатор пользователя", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    private String userId;

    @NotNull
    @Schema(description = "Время приема", example = "2025-03-24")
    private LocalDate dateTime;
}
