package com.example.calorietrack.setvice;

import com.example.calorietrack.dto.MealCreateRequest;
import com.example.calorietrack.dto.MealInfoResponse;
import com.example.calorietrack.dto.PortionDto;
import com.example.calorietrack.entity.MealDishEntity;
import com.example.calorietrack.entity.MealEntity;
import com.example.calorietrack.exception.CalorieTrackException;
import com.example.calorietrack.mapper.MealDishMapper;
import com.example.calorietrack.mapper.MealMapper;
import com.example.calorietrack.repository.DishRepository;
import com.example.calorietrack.repository.MealDishRepository;
import com.example.calorietrack.repository.MealRepository;
import com.example.calorietrack.repository.UsersRepository;
import com.example.calorietrack.setvice.api.CaloriePlannerService;
import com.example.calorietrack.setvice.api.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * Реализания {@link MealService}
 */
@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final MealDishRepository mealDishRepository;
    private final DishRepository dishRepository;
    private final UsersRepository usersRepository;
    private final CaloriePlannerService caloriePlannerService;

    private final MealDishMapper mealDishMapper;
    private final MealMapper mealMapper;


    @Override
    public MealInfoResponse mealAddition(MealCreateRequest newMeal) {
        MealEntity mealEntity = mealMapper.toEntity(newMeal);

        if (!usersRepository.existsById(newMeal.getUserId()))
            throw new CalorieTrackException("Пользователь не найден");

        for (PortionDto portion : newMeal.getPortionList()) {
            if (!dishRepository.existsById(portion.getDishId()))
                throw new CalorieTrackException("Блюдо с ID " + portion.getDishId() + " не найдено");
        }

        mealRepository.save(mealEntity);
        mealDishRepository.saveAll(mealDishMapper.toEntityList(newMeal.getPortionList(), mealEntity));

        return mealMapper.toDto(mealEntity);
    }

}
