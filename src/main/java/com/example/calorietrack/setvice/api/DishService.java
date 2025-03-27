package com.example.calorietrack.setvice.api;

import com.example.calorietrack.dto.DishCreateRequest;
import com.example.calorietrack.dto.DishInfoResponse;

/**
 * Сервис логики запросов блюд
 */
public interface DishService {
    /**
     * Метод добавнения нового блюда
     *
     * @param newDish запрос на добовление нового блюда
     * @return ответ с информацией о блюде {@link DishInfoResponse}
     */
    DishInfoResponse dishAddition (DishCreateRequest newDish);

    /**
     * Метод поиска блюда по ID
     *
     * @param dishId ID блюда
     * @return ответ с информацией о блюде {@link DishInfoResponse}
     */
    DishInfoResponse sendDishById (String dishId);
}
