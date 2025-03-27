package com.example.calorietrack.setvice;

import com.example.calorietrack.dto.UserCreateRequest;
import com.example.calorietrack.dto.UserInfoResponse;
import com.example.calorietrack.entity.UserEntity;
import com.example.calorietrack.exception.CalorieTrackException;
import com.example.calorietrack.mapper.UserMapper;
import com.example.calorietrack.repository.UsersRepository;
import com.example.calorietrack.setvice.api.CaloriePlannerService;
import com.example.calorietrack.setvice.api.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link UsersService}
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final CaloriePlannerService caloriePlannerService;

    private final UsersRepository usersRepository;

    private final UserMapper userMapper;

    @Override
    public UserInfoResponse userAddition(UserCreateRequest newUser) {
        UserEntity userEntity = userMapper.toEntity(newUser, caloriePlannerService.calorieIntakeCalculation(newUser));
        usersRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserInfoResponse sendUserById(String userId) {
        return userMapper.toDto(
                usersRepository.findById(userId).orElseThrow(() -> new CalorieTrackException("Пользователь ненайден с ID "+userId))
        );
    }
}