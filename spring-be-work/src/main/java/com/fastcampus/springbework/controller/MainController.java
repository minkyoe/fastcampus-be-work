package com.fastcampus.springbework.controller;


import com.fastcampus.springbework.domain.Member;
import com.fastcampus.springbework.domain.Team;
import com.fastcampus.springbework.dto.MemberResponseDto;
import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.dto.TeamSaveRequestDto;
import com.fastcampus.springbework.service.MemberService;
import java.util.*;

import com.fastcampus.springbework.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MemberService memberService;
    private final TeamService teamService;

    @PostMapping("/member")
    public Long save(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    @GetMapping("/member")
    public List<Member> findMembers() {
        return memberService.findAll();
    }

    @PostMapping("/team")
    public Long save(@RequestBody TeamSaveRequestDto requestDto) {
        return teamService.save(requestDto);
    }

    @GetMapping("/team")
    public List<Team> findTeams() {
        return teamService.findAll();
    }

}
