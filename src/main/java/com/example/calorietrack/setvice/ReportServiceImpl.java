package com.example.calorietrack.setvice;

import com.example.calorietrack.dto.DailyReportRequest;
import com.example.calorietrack.dto.DailyReportResponse;
import com.example.calorietrack.entity.MealDishEntity;
import com.example.calorietrack.entity.MealEntity;
import com.example.calorietrack.exception.CalorieTrackException;
import com.example.calorietrack.mapper.ReportMapper;
import com.example.calorietrack.repository.MealDishRepository;
import com.example.calorietrack.repository.MealRepository;
import com.example.calorietrack.repository.UsersRepository;
import com.example.calorietrack.setvice.api.CaloriePlannerService;
import com.example.calorietrack.setvice.api.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Реализация {@link ReportService}
 */
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final UsersRepository usersRepository;
    private final MealRepository mealRepository;
    private final MealDishRepository mealDishRepository;

    private final ReportMapper reportMapper;

    private final CaloriePlannerService caloriePlannerService;
    @Override
    public DailyReportResponse createDalyReport(DailyReportRequest dailyReportRequest) {

        if (!usersRepository.existsById(dailyReportRequest.getUserId()))
            throw new CalorieTrackException("Пользователь не найден");
        LocalDateTime firstData = dailyReportRequest.getDateTime().atTime(0, 0, 0, 0);
        LocalDateTime secondData = dailyReportRequest.getDateTime().atTime(23, 59, 59, 53100);
        LinkedList<MealEntity> mealEntityList = mealRepository.findMealsByUserIdAndDate(dailyReportRequest.getUserId(), firstData, secondData);
        LinkedList<MealDishEntity> mealDishEntityList = new LinkedList<>();
        mealEntityList.forEach(mealEntity -> {
            mealDishEntityList.addAll(mealDishRepository.findAllByMeal_MealId(mealEntity.getMealId()));
        });
        var totalCalorie = caloriePlannerService.totalCalorie(mealDishEntityList);
        var dailyValue = usersRepository.findDailyValueById(dailyReportRequest.getUserId());
        return reportMapper.toDtoDailyReport( totalCalorie,mealEntityList,
                caloriePlannerService.checkCalorie(totalCalorie,dailyValue));
    }
}
