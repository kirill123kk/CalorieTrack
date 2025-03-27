package com.example.calorietrack.mapper;


import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.dto.UserInfoResponse;
import com.example.calorietrack.entity.DishEntity;
import com.example.calorietrack.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Маппер для преобразования {@link UserInfoResponse} и {@link UserEntity}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {


    /**
     * Метод преобразования из {@link UserEntity} в {@link UserInfoResponse}
     *
     * @param userEntity
     * @return {@link UserInfoResponse}
     */
    UserInfoResponse toDto(UserEntity userEntity);

    /**
     * Метод преобразования из {@link UserCreateRequest} в {@link UserEntity}
     *
     * @param userCreateRequest запрос на создание пользователя
     * @param dailyValue дневная норма калорий
     * @return {@link UserEntity}
     */
    @Mapping(target = "dailyValue", source = "dailyValue")
    @Mapping(target = "userId", ignore = true)
    UserEntity toEntity(UserCreateRequest userCreateRequest, Integer dailyValue);

}
