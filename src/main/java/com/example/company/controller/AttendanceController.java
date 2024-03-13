package com.example.company.controller;

import com.example.company.dto.response.attendance.AttendanceSumResponse;
import com.example.company.service.AttendanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AttendanceController {
    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/api/{id}/{date}")
    public AttendanceSumResponse getWorkTime(@PathVariable Long id, @PathVariable LocalDate date) {
        return attendanceService.getWorkTime(id, date);
    }

    @PostMapping("/api/start/{id}/{date}")
    public void startWork(@PathVariable Long id, @PathVariable LocalDate date) {
        attendanceService.startWork(id, date);
    }

    @PostMapping("/api/end/{id}/{date}")
    public void endWork(@PathVariable Long id, @PathVariable LocalDate date) {
        attendanceService.endWork(id, date);
    }
}
