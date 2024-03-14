package com.example.company.dto.request.member;

import com.example.company.domain.Role;
import lombok.Getter;

import java.time.LocalDate;

/**
 * 입력받는 형태를 팀 이름으로 받을 것인가? 아니면 팀의 Id로 받을 것인가.
 * 고민해볼 필요가 있을 것 같다.
 */
@Getter
public class MemberRequest {

    private String name;
    private Long teamId;
    private Role role;
    private LocalDate birthday;
    private LocalDate workStartDate;

}
