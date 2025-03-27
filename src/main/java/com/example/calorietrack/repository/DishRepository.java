package com.example.calorietrack.repository;

import com.example.calorietrack.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей dish
 */
@Repository
public interface DishRepository extends JpaRepository<DishEntity, String> {
}
