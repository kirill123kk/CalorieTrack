package com.example.calorietrack;

import com.example.calorietrack.dto.MealCreateRequest;
import com.example.calorietrack.dto.MealInfoResponse;
import com.example.calorietrack.dto.PortionDto;
import com.example.calorietrack.entity.MealEntity;
import com.example.calorietrack.exception.CalorieTrackException;
import com.example.calorietrack.mapper.MealMapper;
import com.example.calorietrack.repository.DishRepository;
import com.example.calorietrack.repository.MealDishRepository;
import com.example.calorietrack.repository.MealRepository;
import com.example.calorietrack.repository.UsersRepository;
import com.example.calorietrack.setvice.MealServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MealServiceTest {

    @Mock
    private MealMapper mealMapper;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private DishRepository dishRepository;

    @Mock
    private MealRepository mealRepository;

    @Mock
    private MealDishRepository mealDishRepository;


    @InjectMocks
    private MealServiceImpl mealService;


    @Test
    public void testMealAddition_UserNotFound() {

        MealCreateRequest newMeal = new MealCreateRequest();
        newMeal.setUserId("a6bbb1d8-36d6-4313-8336a4755fd0");

        when(usersRepository.existsById(newMeal.getUserId())).thenReturn(false); // Пользователь не найден

        // Проверка выбрасывания исключения
        CalorieTrackException exception = assertThrows(CalorieTrackException.class, () -> mealService.mealAddition(newMeal));
        assertEquals("Пользователь не найден", exception.getMessage());

        verify(usersRepository, times(1)).existsById(newMeal.getUserId());
    }

    @Test
    public void testMealAddition_DishNotFound() {

        MealCreateRequest newMeal = new MealCreateRequest();
        newMeal.setUserId("a6bbb1d8-36d6-4313-bbb3-8336a4755fd0");
        PortionDto portion = new PortionDto();
        portion.setDishId("4326ce89-85fe-4005-9a5d-ccdce623c3b");
        portion.setQuantity(1f);
        LinkedList<PortionDto> list = new LinkedList<>();
        list.add(portion);
        newMeal.setPortionList(list);

        when(usersRepository.existsById(newMeal.getUserId())).thenReturn(true); // Пользователь найден
        when(dishRepository.existsById(portion.getDishId())).thenReturn(false); // Блюдо не найдено

        // Проверка выбрасывания исключения
        CalorieTrackException exception = assertThrows(CalorieTrackException.class, () -> mealService.mealAddition(newMeal));
        assertEquals("Блюдо с ID 4326ce89-85fe-4005-9a5d-ccdce623c3b не найдено", exception.getMessage());

        verify(usersRepository, times(1)).existsById(newMeal.getUserId());
        verify(dishRepository, times(1)).existsById(portion.getDishId());
    }

    @Test
    public void testMealAddition_Successful() {

        MealCreateRequest newMeal = new MealCreateRequest();
        newMeal.setUserId("a6bbb1d8-36d6-4313-bbb3-8336a4755fd0");
        PortionDto portion = new PortionDto();
        portion.setDishId("4326ce89-85fe-4005-9a5d-ccd2ce623c3b");
        portion.setQuantity(1f);
        LinkedList<PortionDto> list = new LinkedList<>();
        list.add(portion);
        newMeal.setPortionList(list);

        MealEntity mealEntity = new MealEntity();
        MealInfoResponse mealResponse = new MealInfoResponse();

        when(usersRepository.existsById(newMeal.getUserId())).thenReturn(true); // Пользователь найден
        when(dishRepository.existsById(portion.getDishId())).thenReturn(true); // Блюдо найдено
        when(mealMapper.toEntity(newMeal)).thenReturn(mealEntity);
        when(mealMapper.toDto(mealEntity)).thenReturn(mealResponse);

        MealInfoResponse response = mealService.mealAddition(newMeal);

        assertNotNull(response);
        verify(usersRepository, times(1)).existsById(newMeal.getUserId());
        verify(dishRepository, times(1)).existsById(portion.getDishId());
        verify(mealRepository, times(1)).save(mealEntity);
        verify(mealDishRepository, times(1)).saveAll(any());
    }
}
