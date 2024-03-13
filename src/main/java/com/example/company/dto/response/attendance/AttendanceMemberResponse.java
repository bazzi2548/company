package com.example.company.dto.response.attendance;

import com.example.company.domain.Attendance;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AttendanceMemberResponse {

    private LocalDate date;
    private long workingMinutes;

    public AttendanceMemberResponse(Attendance attendance) {
        this.date = attendance.getDate();
        this.workingMinutes = attendance.getWorkingMinutes();
    }
}
