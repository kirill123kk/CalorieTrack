package com.example.calorietrack.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * DTO с информацией о пользователе.
 */
@Data
public class UserInfoResponse {

    @NotNull
    @Schema(description = "индентификатор пользователя", example = "01234567-89AB-CDEF-0123-456789ABCDEF")
    private String userId;

    @NotNull
    @Schema(description = "имя пользователя", example = "Григорий")
    private String name;

    @NotNull
    @Schema(description = "вес пользователя", example = "88,5")
    private Float weight;

    @NotNull
    @Schema(description = "цель пользователя (Похудение, Поддержание, Набор массы)", example = "(Loss, Maintenance, Gain)")
    private String purpose;

    @NotNull
    @Schema(description = "вес пользователя", example = "88,5")
    private Integer dailyValue;
}
