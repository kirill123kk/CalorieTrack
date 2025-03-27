package com.example.calorietrack.controller;

import com.example.calorietrack.dto.DishCreateRequest;
import com.example.calorietrack.dto.DishInfoResponse;
import com.example.calorietrack.setvice.api.DishService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для раьботы с блюдами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    /**
     * Метод отработки запроса на создагие нового блюда
     *
     * @param newDish запрос на создание блюда
     * @return ответ с информацией о блюде {@link DishInfoResponse}
     */
    @Operation(description = "Создание нового блюда")
    @PostMapping("/new")
    public DishInfoResponse addNewDish(@RequestBody @Valid DishCreateRequest newDish) {
        return dishService.dishAddition(newDish);
    }

    /**
     * Метод отработки запроса поиска блюда по ID
     *
     * @param userId ID блюда
     * @return ответ с информацией о блюде {@link DishInfoResponse}
     */
    @Operation(description = "Поиск блюда")
    @GetMapping("/id")
    public DishInfoResponse senDishDataById(@RequestParam String userId) {
        return dishService.sendDishById(userId);
    }

}
