package com.fastcampus.springbework.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Entity
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @Column(nullable = false, insertable = false, updatable = false,
            columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @CreatedDate
    private String foundedDate;
//    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name, String location, String foundedDate) {
        this.name = name;
        this.location = location;
        this.foundedDate = foundedDate;
//        this.members = members;
    }
}