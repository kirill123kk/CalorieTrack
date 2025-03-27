package com.example.calorietrack.setvice.api;

import com.example.calorietrack.dto.MealCreateRequest;
import com.example.calorietrack.dto.MealInfoResponse;

/**
 * Сервис логики запросов приема пищи
 */
public interface MealService {
    /**
     * Метод добавнения нового приема пищи
     *
     * @param newMeal запрос на добовление нового приема пищи
     * @return ответ с информацией о приема пищи
     */
    MealInfoResponse mealAddition (MealCreateRequest newMeal);
}
