package com.fastcampus.springbework.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
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