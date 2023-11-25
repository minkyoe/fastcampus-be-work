package com.fastcampus.springbework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {

    private Long memberId;
    private String firstName;
    private String lastName;
    private String address;

}
