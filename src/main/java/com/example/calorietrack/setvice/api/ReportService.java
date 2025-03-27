package com.example.calorietrack.setvice.api;

import com.example.calorietrack.dto.DailyReportRequest;
import com.example.calorietrack.dto.DailyReportResponse;

/**
 * Сервис формирования отчетов
 */
public interface ReportService {
    DailyReportResponse createDalyReport (DailyReportRequest dailyReportRequvest);
}
