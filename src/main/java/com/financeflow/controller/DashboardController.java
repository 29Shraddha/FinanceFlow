package com.financeflow.controller;

import com.financeflow.dto.DashboardResponseDTO;
import com.financeflow.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponseDTO getDashboard() {
        return dashboardService.getDashboard();
    }
}