package com.example.calorietrack;

import com.example.calorietrack.dto.DishCreateRequest;
import com.example.calorietrack.dto.DishInfoResponse;
import com.example.calorietrack.entity.DishEntity;
import com.example.calorietrack.mapper.DishMapper;
import com.example.calorietrack.repository.DishRepository;
import com.example.calorietrack.setvice.DishServiceImpl;
import com.example.calorietrack.setvice.api.DishService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class DishServiceTest {

    @Mock
    private DishMapper dishMapper; // Мок для маппера

    @Mock
    private DishRepository dishRepository; // Мок для репозитория

    @InjectMocks
    private DishServiceImpl dishService; // Тестируемый класс


    @Test
    public void testDishAddition() {

        DishCreateRequest newDish = new DishCreateRequest();
        newDish.setName("Паста");
        newDish.setCalorie(400);

        DishEntity mockEntity = new DishEntity();
        mockEntity.setName("Паста");
        mockEntity.setCalorie(400);

        DishInfoResponse mockResponse = new DishInfoResponse();
        mockResponse.setName("Паста");
        mockResponse.setCalorie(400);

        when(dishMapper.toEntity(newDish)).thenReturn(mockEntity);
        when(dishRepository.save(mockEntity)).thenReturn(mockEntity);
        when(dishMapper.toDto(mockEntity)).thenReturn(mockResponse);

        DishInfoResponse response = dishService.dishAddition(newDish);

        assertNotNull(response);
        assertEquals("Паста", response.getName());
        assertEquals(400, response.getCalorie());

        verify(dishMapper, times(1)).toEntity(newDish);
        verify(dishRepository, times(1)).save(mockEntity);
        verify(dishMapper, times(1)).toDto(mockEntity);
    }
}
