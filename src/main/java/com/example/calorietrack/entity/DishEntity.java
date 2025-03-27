package com.example.calorietrack.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * Сущность таблицы dish.
 */
@Entity
@Getter
@Setter
@Table(name = "dish")
public class DishEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String dishId;

    @Column(name = "name")
    private String name;

    @Column(name = "calorie")
    private Integer calorie;

    @Column(name = "proteins")
    private Float proteins;

    @Column(name = "fats")
    private Float fats;

    @Column(name = "carbohydrates")
    private Float carbohydrates;
}
