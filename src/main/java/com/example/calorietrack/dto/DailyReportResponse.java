package com.example.calorietrack.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.LinkedList;

/**
 * DTO для формирования отчета за день
 */
@Data
public class DailyReportResponse {

    @NotNull
    @Schema(description = "количесво колорий за день", example = "1350")
    private Integer totalCalories;

    @NotNull
    private LinkedList<MealInfoResponse> mealInfoResponseList;

    @NotNull
    @Schema(description = " проверка, уложился ли пользователь в свою дневную норму калорий",
            example = "Хороший результат, так держать 1350/2754")
    private String check;

}
