package com.example.calorietrack.controller;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.dto.UserInfoResponse;
import com.example.calorietrack.setvice.api.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер отслеживания нормы калорий
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    /**
     * Метод отработки запроса на создагие нового пользователя.
     *
     * @param newUser запрос на создание нового пользователя
     * @return ответ с информацией о состоянии пользователя {@link UserInfoResponse}
     */
    @Operation(description = "Создание нового пользователя")
    @PostMapping("/new")
    public UserInfoResponse addNewUser(@RequestBody @Valid UserCreateRequest newUser) {
        log.info("Received POST request ", newUser);
        return usersService.userAddition(newUser);
    }

    /**
     * Метод отработки запроса поиска клиента по ID.
     *
     * @param userId ID пользователя
     * @return ответ с информацией о состоянии пользователя {@link UserInfoResponse}
     */
    @Operation(description = "Поиск пользователя")
    @GetMapping("/id")
    public UserInfoResponse sendUserDataById(@RequestParam String userId) {
        log.info("Received POST request ", userId);
        return usersService.sendUserById(userId);
    }
}
