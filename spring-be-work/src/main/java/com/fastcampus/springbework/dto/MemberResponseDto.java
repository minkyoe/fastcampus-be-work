package com.fastcampus.springbework.dto;

import com.fastcampus.springbework.domain.Team;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private Team team;

    public MemberResponseDto(Long id, String firstName, String lastName, String address, String joinedDate, Team team) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = joinedDate;
        this.team = team;
    }
}
