package com.example.calorietrack.repository;

import com.example.calorietrack.entity.MealDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

/**
 * Репозиторий для работы с таблицей meal_dish
 */
@Repository
public interface MealDishRepository extends JpaRepository<MealDishEntity, String> {

    LinkedList<MealDishEntity> findAllByMeal_MealId(String mealId);
}
