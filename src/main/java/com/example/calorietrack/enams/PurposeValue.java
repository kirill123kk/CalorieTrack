package com.example.calorietrack.enams;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Перечисление всех целей (Похудение, Поддержание, Набор массы).
 */
@Getter
@RequiredArgsConstructor
public enum PurposeValue {
    Loss("Loss"),
    Maintenance("Maintenance"),
    Gain("Gain");
    private final String value;
}
