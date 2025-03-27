package com.example.calorietrack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
/**
 * Сущность таблицы meal.
 */
@Entity
@Getter
@Setter
@Table(name = "meal")
public class MealEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "user_id")
    private String userId;

}
