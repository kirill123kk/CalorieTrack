package com.example.calorietrack.mapper;

import com.example.calorietrack.dto.DishCreateRequest;
import com.example.calorietrack.dto.DishInfoResponse;
import com.example.calorietrack.entity.DishEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Маппер для преобразования {@link DishEntity} и {@link DishInfoResponse}.
 */

@Mapper(componentModel = "spring")
public interface DishMapper {

    /**
     * Метод преобразования из {@link DishEntity} в {@link DishInfoResponse}
     *
     * @param dishEntity
     * @return {@link DishInfoResponse}
     */
    DishInfoResponse toDto(DishEntity dishEntity);

    /**
     * Метод преобразования из {@link DishCreateRequest} в {@link DishEntity}
     *
     * @param dishCreateRequest
     * @return {@link DishEntity}
     */
    @Mapping(target = "dishId", ignore = true)
    DishEntity toEntity(DishCreateRequest dishCreateRequest);
}
