package com.example.company.service;

import com.example.company.domain.Attendance;
import com.example.company.domain.Member;
import com.example.company.dto.response.attendance.AttendanceMemberResponse;
import com.example.company.dto.response.attendance.AttendanceSumResponse;
import com.example.company.repository.AttendanceRepository;
import com.example.company.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final MemberRepository memberRepository;
    public AttendanceService(AttendanceRepository attendanceRepository, MemberRepository memberRepository) {
        this.attendanceRepository = attendanceRepository;
        this.memberRepository = memberRepository;
    }

    public AttendanceSumResponse getWorkTime(Long id, LocalDate date) {
        Member member = getMember(id);
        LocalDate startMonth = date.withDayOfMonth(1);
        LocalDate lastMonth = date.withDayOfMonth(date.lengthOfMonth());

        List<AttendanceMemberResponse> responses = attendanceRepository.findAllByMemberIdAndDateBetweenAndIsArrivedFalseOrderByDateAsc(id, startMonth, lastMonth)
                .stream()
                .map(AttendanceMemberResponse::new)
                .collect(Collectors.toList());

        return new AttendanceSumResponse(responses);
    }

    @Transactional
    public void startWork(Long id, LocalDate date) {
        Member member = getMember(id);

        Attendance attendance = new Attendance(date);
        attendance.setMember(member);
        attendance.startWork();
        attendanceRepository.save(attendance);
    }

    @Transactional
    public void endWork(Long id, LocalDate date) {
        Member member = getMember(id);

        Attendance attendance = attendanceRepository.findByMemberAndDate(member, date);
        attendance.endWork();
    }

    private Member getMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
