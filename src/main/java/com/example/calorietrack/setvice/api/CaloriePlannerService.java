package com.example.calorietrack.setvice.api;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.entity.MealDishEntity;

import java.util.LinkedList;

/**
 * Сервис расчета калорий.
 */
public interface CaloriePlannerService {
    /**
     * Метод расчета нормы калорий.
     *
     * @param newUser запрос на создание нового пользователя
     * @return результат каллорий
     */
    Integer calorieIntakeCalculation(UserCreateRequest newUser);

    /**
     * Метод расчета общих калорий.
     *
     * @param mealDishEntityList
     * @return количество калорий
     */
    Integer totalCalorie(LinkedList<MealDishEntity> mealDishEntityList);

    /**
     * Метод проверки, уложился ли пользователь в свою дневную норму калорий.
     *
     * @param totalCalories общее количество калорий получиных за день
     * @param dailyValue дневная норма
     * @return отыет проверки.
     */
    String checkCalorie(Integer totalCalories, Integer dailyValue);
}
