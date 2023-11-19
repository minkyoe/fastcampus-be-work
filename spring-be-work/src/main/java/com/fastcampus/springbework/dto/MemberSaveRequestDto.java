package com.fastcampus.springbework.dto;

import com.fastcampus.springbework.domain.Member;
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

    @Builder
    public MemberSaveRequestDto(String firstName, String lastName, String address, String joinedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = joinedDate;
    }

    public Member toEntity() {
        return Member.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .joinedDate(joinedDate)
                .build();
    }
}
