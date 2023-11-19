package com.fastcampus.springbework.controller;


import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MemberService memberService;

    @PostMapping("/member")
    public Long save(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }

}
