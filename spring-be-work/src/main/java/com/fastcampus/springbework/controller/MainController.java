package com.fastcampus.springbework.controller;


import com.fastcampus.springbework.domain.Member;
import com.fastcampus.springbework.domain.Team;
import com.fastcampus.springbework.dto.*;
import com.fastcampus.springbework.service.MemberService;
import java.util.*;

import com.fastcampus.springbework.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MemberService memberService;
    private final TeamService teamService;

    // 멤버 등록
    @PostMapping("/member")
    public ResponseDto save(@RequestBody MemberSaveRequestDto requestDto) {
        try {
            Long memberId = memberService.save(requestDto);
            return new ResponseDto("SUCCESS", "멤버 등록 성공", memberService.findById(memberId));
        } catch (Exception e) {
            return new ResponseDto("FAIL", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 모든 멤버 조회
    @GetMapping("/member")
    public List<Member> findMembers() {
        return memberService.findAll();
    }

    // 멤버 개별 조회
    @GetMapping("/member/{id}")
    public ResponseDto findMember(@PathVariable Long id) {
        try {
            Member member = memberService.findById(id);
            return new ResponseDto("SUCCESS", "멤버 조회 성공", member);
        } catch (Exception e) {
            return new ResponseDto("FAIL", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public ResponseDto findTeam(@PathVariable Long id) {
        try {
            Team team = teamService.findById(id);
            return new ResponseDto("SUCCESS", "팀 조회 성공", team);
        } catch (Exception e) {
            return new ResponseDto("FAIL", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 멤버 개별 수정
    @PutMapping("/member")
    public ResponseDto updateMember(@RequestBody MemberUpdateRequestDto requestDto) {
        try {
            return new ResponseDto("SUCCESS", "멤버 개별 수정 성공", memberService.updateMember(requestDto));
        } catch (Exception e) {
            return new ResponseDto("FAIL", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 팀 개별 수정
    @PutMapping("/team")
    public ResponseDto updateTeam(@RequestBody TeamUpdateRequestDto requestDto) {
        try {
            return new ResponseDto("SUCCESS", "팀 개별 수정 성공", teamService.updateTeam(requestDto));
        } catch (Exception e) {
            return new ResponseDto("FAIL", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
