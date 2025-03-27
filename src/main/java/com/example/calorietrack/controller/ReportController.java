package com.example.calorietrack.controller;

import com.example.calorietrack.dto.DailyReportRequest;
import com.example.calorietrack.dto.DailyReportResponse;
import com.example.calorietrack.setvice.api.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для раьботы с отчетами
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    /**
     * Метод отработки запроса на создагие дневноого отчета
     *
     * @param dailyReportRequest запрос на создание отчета
     * @return отчет о питании за день
     */
    @Operation(description = "Дневной отчет о питании")
    @PostMapping("/daily")
    public DailyReportResponse createDailyReport(@RequestBody @Valid DailyReportRequest dailyReportRequest) {
        return reportService.createDalyReport(dailyReportRequest);
    }
}
