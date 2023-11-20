package com.fastcampus.springbework.service;

import com.fastcampus.springbework.domain.Team;
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
        return teamRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
