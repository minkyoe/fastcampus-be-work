package com.fastcampus.springbework.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamUpdateRequestDto {

    private Long teamId;
    private String name;
    private String location;
}
