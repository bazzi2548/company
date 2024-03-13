package com.example.company.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    private LocalDate date;
    private long workingMinutes;

    private boolean isArrived;
    private LocalDateTime startWorkTime;
    private LocalDateTime endWorkTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Attendance(LocalDate date) {
        this.date = date;
    }

    public void startWork() {
        if(!isArrived){
            startWorkTime = LocalDateTime.now();
            isArrived = true;
        }
    }

    public void endWork(){
        if(isArrived){
            endWorkTime = LocalDateTime.now();
            isArrived = false;
            workingMinutes = ChronoUnit.MINUTES.between(startWorkTime, endWorkTime);
        }
    }

    public void setMember(Member member) {
        this.member = member;
        if (!member.getAttendances().contains(this)) {
            member.getAttendances().add(this);
        }
    }
}
