package com.example.calorietrack.dto;

import lombok.Data;

import java.util.LinkedList;
@Data
public class ErrorsResponse {
    private LinkedList<ErrorResponse> errors;
}
