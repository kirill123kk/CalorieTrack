package com.example.calorietrack.mapper;

import com.example.calorietrack.dto.DailyReportResponse;
import com.example.calorietrack.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.LinkedList;

/**
 * Маппер для создания {@link DailyReportResponse}.
 */
@Mapper(componentModel = "spring", uses = {MealMapper.class})
public interface ReportMapper {

    @Mapping(target = "mealInfoResponseList", source = "mealEntityList")
    @Mapping(target = "check", source = "result")
    DailyReportResponse toDtoDailyReport(Integer totalCalories, LinkedList<MealEntity> mealEntityList, String result);
}
