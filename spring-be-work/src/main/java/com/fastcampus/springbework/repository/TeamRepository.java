package com.fastcampus.springbework.repository;

import com.fastcampus.springbework.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
