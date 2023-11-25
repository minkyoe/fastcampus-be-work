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
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MemberService memberService;
    private final TeamService teamService;

    // 멤버 등록
    @PostMapping("/member")
    public Long save(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    // 모든 멤버 조회
    @GetMapping("/member")
    public List<Member> findMembers() {
        return memberService.findAll();
    }

    // 멤버 개별 조회
    @GetMapping("/member/{id}")
    public Member findMember(@PathVariable Long id) {
        return memberService.findById(id);
    }

    // 팀 등록
    @PostMapping("/team")
    public Long save(@RequestBody TeamSaveRequestDto requestDto) {
        return teamService.save(requestDto);
    }

    // 모든 팀 조회
    @GetMapping("/team")
    public List<Team> findTeams() {
        return teamService.findAll();
    }

    // 팀 개별 조회
    @GetMapping("/team/{id}")
    public Team findTeam(@PathVariable Long id) {
        return teamService.findById(id);
    }
}
