package com.fastcampus.springbework.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String joinedDate;

//    private Team team;

    @Builder
    public Member(String firstName, String lastName, String address, String joinedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.joinedDate = joinedDate;
    }
}
