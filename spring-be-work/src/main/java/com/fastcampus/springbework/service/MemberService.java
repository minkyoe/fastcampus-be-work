package com.fastcampus.springbework.service;

import com.fastcampus.springbework.dto.MemberResponseDto;
import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.repository.MemberRepository;
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

    @Transactional
    public Long save(MemberSaveRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }

//    public List<MemberResponseDto> findAll() {
//        return memberRepository.findAll()
//                .stream()
//                .map(MemberResponseDto::new)
//                .collect(Collectors.toList());
//    }

}
