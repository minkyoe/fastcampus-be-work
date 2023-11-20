package com.fastcampus.springbework.dto;

import com.fastcampus.springbework.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {

    private String name;
    private String location;
    private String foundedDate;

    @Builder
    public TeamSaveRequestDto(String name, String location, String foundedDate) {
        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
    }

    public Team toEntity(){
        return Team.builder()
                .name(name)
                .location(location)
                .foundedDate(foundedDate)
                .build();
    }
}
