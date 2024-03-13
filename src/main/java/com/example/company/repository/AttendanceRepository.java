package com.example.company.repository;

import com.example.company.domain.Attendance;
import com.example.company.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findAllByMemberIdAndDateBetweenAndIsArrivedFalseOrderByDateAsc(Long memberId, LocalDate startMonth, LocalDate lastMonth);

    Attendance findByMemberAndDate(Member member, LocalDate date);
}
