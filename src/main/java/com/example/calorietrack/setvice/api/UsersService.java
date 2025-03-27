package com.example.calorietrack.setvice.api;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.dto.UserInfoResponse;

/**
 * Сервис логики запросов.
 */
public interface UsersService {
    /**
     * Метод добовления пользователя
     *
     * @param newUser запрос на создание нового пользователя
     * @return ответ с информацией о пользователе {@link UserInfoResponse}
     */
    UserInfoResponse userAddition(UserCreateRequest newUser);

    /**
     * Метод поиска пользователя по ID
     *
     * @param userId ID пользователя которого надо найти
     * @return ответ с информацией о пользователе {@link UserInfoResponse}
     */
    UserInfoResponse sendUserById(String userId);
}
