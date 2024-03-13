package com.example.company.dto.response.attendance;

import lombok.Getter;

import java.util.List;
@Getter
public class AttendanceSumResponse {
    private List<AttendanceMemberResponse> detail;
    private long sum;

    public AttendanceSumResponse(List<AttendanceMemberResponse> detail) {
        this.detail = detail;
        this.sum = detail.stream()
                .mapToLong(AttendanceMemberResponse::getWorkingMinutes)
                .sum();
    }
}
