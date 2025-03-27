package com.example.calorietrack.controller;

import com.example.calorietrack.dto.DailyReportResponse;
import com.example.calorietrack.dto.MealCreateRequest;
import com.example.calorietrack.dto.MealInfoResponse;
import com.example.calorietrack.setvice.api.MealService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для раьботы с приемом пищи
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/meal")
public class MealController {
    private final MealService mealService;

    /**
     * Метод отработки запроса на создагие нового приема пищи
     *
     * @param newMeal запрос на создание нового приема пищи
     * @return ответ с информацией о приеме пищи {@link MealInfoResponse}
     */
    @Operation(description = "Создание нового приема пищи")
    @PostMapping("/new")
    public MealInfoResponse addNewMeal(@RequestBody @Valid MealCreateRequest newMeal) {
        return mealService.mealAddition(newMeal);
    }
}
