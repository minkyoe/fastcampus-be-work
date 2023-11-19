package com.fastcampus.springbework.repository;

import com.fastcampus.springbework.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
