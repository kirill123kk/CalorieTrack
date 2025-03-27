package com.example.calorietrack.mapper;

import com.example.calorietrack.dto.DishInfoResponse;
import com.example.calorietrack.dto.PortionDto;
import com.example.calorietrack.entity.DishEntity;
import com.example.calorietrack.entity.MealDishEntity;
import com.example.calorietrack.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.LinkedList;

/**
 * Маппер для преобразования {@link MealDishEntity}.
 */
@Mapper(componentModel = "spring")
public interface MealDishMapper {


    /**
     * Метод создания {@link MealDishEntity}
     *
     * @param portionDto колическво порций блюда
     * @param mealId {@link MealEntity}
     * @return {@link MealDishEntity}
     */
    @Mapping(target = "dish", source = "portionDto.dishId")
    @Mapping(target = " portionCount", source = "portionDto.quantity")
    @Mapping(target = "meal", source = "mealId")
    MealDishEntity toEntity(PortionDto portionDto, MealEntity mealId);

    default DishEntity mapDish(String dishListId) {
        DishEntity dishEntity = new DishEntity();
        dishEntity.setDishId(dishListId);
        return dishEntity;
    }

    /**
     * Метод создания {@link MealDishEntity}
     *
     * @param portionList  список порций блюда
     * @param mealEntity {@link MealEntity}
     * @return список {@link MealDishEntity}
     */
    default LinkedList<MealDishEntity> toEntityList(LinkedList<PortionDto> portionList, MealEntity mealEntity) {
        LinkedList<MealDishEntity> result = new LinkedList<>();
        for (PortionDto portion : portionList) {
            result.add(toEntity(portion, mealEntity));
        }
        return result;
    }
}
