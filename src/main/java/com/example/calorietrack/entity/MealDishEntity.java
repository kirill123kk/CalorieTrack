package com.example.calorietrack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
/**
 * Сущность таблицы meal_dish.
 */
@Entity
@Getter
@Setter
@Table(name = "meal_dish")
public class MealDishEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String mealDishId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meal_id", nullable = false)
    private MealEntity meal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    private DishEntity dish;

    @Column(name = "portion_count")
    private Float portionCount;
}
