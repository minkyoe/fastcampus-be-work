package com.fastcampus.springbework.service;

import com.fastcampus.springbework.domain.Member;
import com.fastcampus.springbework.domain.Team;
import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.dto.TeamSaveRequestDto;
import com.fastcampus.springbework.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Long save(TeamSaveRequestDto requestDto) {
        Team team = Team.builder()
                .foundedDate(requestDto.getFoundedDate())
                .location(requestDto.getLocation())
                .name(requestDto.getName())
                .build();
        List<MemberSaveRequestDto> members = requestDto.getMembers();
        for (MemberSaveRequestDto memberDto : members) {
            Member member = Member.builder()
                    .firstName(memberDto.getFirstName())
                    .lastName(memberDto.getLastName())
                    .address(memberDto.getAddress())
                    .team(team)
                    .build();
            team.putMember(member);
        }
        return teamRepository.save(team).getId();
    }

    @Transactional
    public Team findById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 Team이 존재하지 않습니다."));
    }

    @Transactional
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
