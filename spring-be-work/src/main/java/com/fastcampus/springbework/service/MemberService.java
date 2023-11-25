package com.fastcampus.springbework.service;

import com.fastcampus.springbework.domain.Member;
import com.fastcampus.springbework.domain.Team;
import com.fastcampus.springbework.dto.MemberResponseDto;
import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.repository.MemberRepository;
import com.fastcampus.springbework.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        Team team = teamRepository.findById(requestDto.getTeamId())
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 Team이 존재하지 않습니다."));

        Member member = Member.builder()
                .lastName(requestDto.getLastName())
                .firstName(requestDto.getFirstName())
                .address(requestDto.getAddress())
                .team(team)
                .build();

        return memberRepository.save(member).getId();
    }

    @Transactional
    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 Member가 존재하지 않습니다."));
    }

    @Transactional
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}
