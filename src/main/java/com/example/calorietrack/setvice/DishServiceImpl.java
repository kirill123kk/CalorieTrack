package com.example.calorietrack.setvice;

import com.example.calorietrack.dto.DishCreateRequest;
import com.example.calorietrack.dto.DishInfoResponse;
import com.example.calorietrack.entity.DishEntity;
import com.example.calorietrack.exception.CalorieTrackException;
import com.example.calorietrack.mapper.DishMapper;
import com.example.calorietrack.repository.DishRepository;
import com.example.calorietrack.setvice.api.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link DishService}
 */
@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    public DishInfoResponse dishAddition(DishCreateRequest newDish) {
        DishEntity dishEntity = dishMapper.toEntity(newDish);
        dishRepository.save(dishEntity);
        return dishMapper.toDto(dishEntity);
    }

    @Override
    public DishInfoResponse sendDishById(String dishId) {
        return dishMapper.toDto(dishRepository.findById(dishId).orElseThrow(() -> new CalorieTrackException("Блюдо не найдено с ID" + dishId)));
    }
}
