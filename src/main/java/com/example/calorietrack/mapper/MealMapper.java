package com.example.calorietrack.mapper;

import com.example.calorietrack.dto.MealCreateRequest;
import com.example.calorietrack.dto.MealInfoResponse;
import com.example.calorietrack.entity.MealDishEntity;
import com.example.calorietrack.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер для преобразования {@link MealEntity} и {@link MealInfoResponse}.
 */
@Mapper(componentModel = "spring")
public interface MealMapper {

    /**
     * Метод создания {@link MealEntity}
     *
     * @param mealCreateRequest {@link MealCreateRequest}
     * @return {@link MealEntity}
     */
    @Mapping(target = "mealId", ignore = true)
    MealEntity toEntity(MealCreateRequest mealCreateRequest);

    /**
     * Метод создания {@link MealInfoResponse}
     *
     * @param mealEntity {@link MealEntity}
     * @return {@link MealInfoResponse}
     */
    @Mapping(target = "mealId", source = "mealEntity.mealId")
    @Mapping(target = "name", source = "mealEntity.name")
    MealInfoResponse toDto (MealEntity mealEntity);
}
