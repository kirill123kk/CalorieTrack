package com.example.calorietrack.repository;

import com.example.calorietrack.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Репозиторий для работы с таблицей meal
 */
@Repository
public interface MealRepository extends JpaRepository<MealEntity, String> {
    @Query("SELECT m FROM MealEntity m WHERE m.userId = :userId AND m.dateTime BETWEEN :start AND :end")
    LinkedList<MealEntity> findMealsByUserIdAndDate(
            @Param("userId") String userId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
