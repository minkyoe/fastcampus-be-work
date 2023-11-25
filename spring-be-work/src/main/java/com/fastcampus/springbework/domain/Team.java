package com.fastcampus.springbework.domain;

import com.fastcampus.springbework.dto.TeamUpdateRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @Column(nullable = false, insertable = false, updatable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @CreatedDate
    private String foundedDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name, String location, String foundedDate) {
        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
    }

    public void putMember(Member member) {
        this.members.add(member);
    }

    public void updateTeam (TeamUpdateRequestDto dto) {
        this.name = dto.getName();
        this.location = dto.getLocation();
    }
}