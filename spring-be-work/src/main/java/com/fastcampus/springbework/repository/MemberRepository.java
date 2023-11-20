package com.fastcampus.springbework.repository;

import com.fastcampus.springbework.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    @Override
//    List<Member> findAll();
}
