package com.example.calorietrack;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.dto.UserInfoResponse;
import com.example.calorietrack.entity.UserEntity;
import com.example.calorietrack.mapper.UserMapper;
import com.example.calorietrack.repository.UsersRepository;
import com.example.calorietrack.setvice.UsersServiceImpl;
import com.example.calorietrack.setvice.api.CaloriePlannerService;
import com.example.calorietrack.setvice.api.UsersService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserMapper userMapper;

    @Mock
    private CaloriePlannerService caloriePlannerService;

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UsersServiceImpl userService;

    @Test
    public void testUserAddition() {
        // Настройка мока входных данных
        UserCreateRequest newUser = new UserCreateRequest();
        newUser.setName("Петя");
        newUser.setAge(25);
        newUser.setWeight(70.5f);
        newUser.setGrowth(175);


        UserEntity mockedEntity = new UserEntity();
        mockedEntity.setName("Петя");
        mockedEntity.setAge(25);
        mockedEntity.setWeight(70.5f);
        mockedEntity.setGrowth(175);
        mockedEntity.setDailyValue(2200);

        UserInfoResponse mockedResponse = new UserInfoResponse();
        mockedResponse.setName("Петя");
        mockedResponse.setWeight(70.5f);
        mockedResponse.setDailyValue(2200);

        when(caloriePlannerService.calorieIntakeCalculation(newUser)).thenReturn(2200); // Мок расчёта калорий
        when(userMapper.toEntity(newUser, 2200)).thenReturn(mockedEntity); // Мок преобразования в сущность
        when(usersRepository.save(mockedEntity)).thenReturn(mockedEntity); // Мок сохранения сущности
        when(userMapper.toDto(mockedEntity)).thenReturn(mockedResponse); // Мок преобразования в DTO

        UserInfoResponse response = userService.userAddition(newUser);

        assertNotNull(response);
        assertEquals("Петя", response.getName());
        assertEquals(70.5f, response.getWeight());
        assertEquals(2200, response.getDailyValue());

        verify(caloriePlannerService, times(1)).calorieIntakeCalculation(newUser);
        verify(userMapper, times(1)).toEntity(newUser, 2200);
        verify(usersRepository, times(1)).save(mockedEntity);
        verify(userMapper, times(1)).toDto(mockedEntity);
    }
}
