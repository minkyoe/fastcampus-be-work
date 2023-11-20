package com.fastcampus.springbework.dto;

import com.fastcampus.springbework.domain.Member;
import com.fastcampus.springbework.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private Team team;
    private Long teamId;

    @Builder
    public MemberSaveRequestDto(String firstName, String lastName, String address, String joinedDate, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = joinedDate;
        this.team = team;
    }

    public Member toEntity() {
        return Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .joinedDate(joinedDate)
                .team(team)
                .build();
    }
}
