package com.fastcampus.springbework;

import com.fastcampus.springbework.dto.MemberSaveRequestDto;
import com.fastcampus.springbework.dto.ResponseDto;
import com.fastcampus.springbework.dto.TeamSaveRequestDto;
import com.fastcampus.springbework.repository.MemberRepository;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBeWorkApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void Member_등록() {
		// given
		MemberSaveRequestDto requestDto = MemberSaveRequestDto.builder()
				.firstName("김")
				.lastName("밍구")
				.address("서울시 도봉구")
				.build();

		String url = "http://localhost:"+port+"/member";

		// when
		ResponseEntity<ResponseDto> responseEntity = restTemplate.postForEntity(url, requestDto, ResponseDto.class);

		// then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(responseEntity.getBody()).isGreaterThan(0L);
	}

	@Test
	public void Team_등록() {
		// given
		MemberSaveRequestDto memberDto = MemberSaveRequestDto.builder()
				.firstName("김")
				.lastName("밍구")
				.address("서울시 도봉구")
				.build();
		List<MemberSaveRequestDto> list = new ArrayList<>();
		list.add(memberDto);

		TeamSaveRequestDto teamDto = TeamSaveRequestDto.builder()
				.location("도봉구")
				.name("첫번째 팀")
				.members(list)
				.build();

		String url = "http://localhost:"+port+"/team";

		// when
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, teamDto, Object.class);

		// then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isInstanceOf(Integer.class);
	}

}
