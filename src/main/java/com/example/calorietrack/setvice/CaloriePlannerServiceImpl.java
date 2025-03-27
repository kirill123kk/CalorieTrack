package com.example.calorietrack.setvice;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.enams.PurposeValue;
import com.example.calorietrack.entity.MealDishEntity;
import com.example.calorietrack.setvice.api.CaloriePlannerService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * Реализация {@link CaloriePlannerService}
 */
@Service
public class CaloriePlannerServiceImpl implements CaloriePlannerService {
    @Override
    public Integer calorieIntakeCalculation(UserCreateRequest newUser) {
        if (newUser.getPurpose().equals(PurposeValue.Loss.getValue()))
            return (int) (88.36 + (13.4 * newUser.getWeight()) + (4.8 * newUser.getGrowth()) - (5.7 * newUser.getAge()));
        if (newUser.getPurpose().equals(PurposeValue.Maintenance.getValue()))
            return (int) ((88.36 + (13.4 * newUser.getWeight()) + (4.8 * newUser.getGrowth()) - (5.7 * newUser.getAge())) * 1.1);
        else
            return (int) ((88.36 + (13.4 * newUser.getWeight()) + (4.8 * newUser.getGrowth()) - (5.7 * newUser.getAge())) * 1.4);
    }


    @Override
    public Integer totalCalorie(LinkedList<MealDishEntity> mealDishEntityList) {
        int total = 0;
        for (MealDishEntity mealDishEntity : mealDishEntityList) {
            total += (int) (mealDishEntity.getDish().getCalorie() * mealDishEntity.getPortionCount());
        }
        return total;
    }

    @Override
    public String checkCalorie(Integer totalCalories, Integer dailyValue) {
        if (totalCalories > dailyValue)
            return "Плохой результат "+ totalCalories+"/" +dailyValue;
        if (totalCalories.equals(dailyValue))
            return "Опасный результат "+ totalCalories+"/" +dailyValue;
        return "Хороший результат, так держать "+ totalCalories+"/" +dailyValue;
    }
}
