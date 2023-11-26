package com.fastcampus.springbework.dto;

import com.fastcampus.springbework.domain.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;

@Getter
@NoArgsConstructor
public class TeamSaveRequestDto {

    private String name;
    private String location;
    private String foundedDate;
    private List<MemberSaveRequestDto> members;

    @Builder
    public TeamSaveRequestDto(String name, String location, String foundedDate, List<MemberSaveRequestDto> members) {
        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
        this.members = members;
    }

    public Team toEntity(){
        return Team.builder()
                .name(name)
                .location(location)
                .foundedDate(foundedDate)
                .build();
    }
}
