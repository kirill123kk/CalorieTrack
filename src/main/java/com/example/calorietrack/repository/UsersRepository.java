package com.example.calorietrack.repository;

import com.example.calorietrack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей users
 */
@Repository
public interface UsersRepository extends JpaRepository<UserEntity, String> {
    @Query("SELECT u.dailyValue FROM UserEntity u WHERE u.userId = :userId")
    int findDailyValueById(@Param("userId") String userId);
}
