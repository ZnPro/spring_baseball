package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.field.FieldRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	private final FieldRepository fieldRepository;
	

	//팀등록과 동시에 경기장 정보까지 같이 넣어주기
	@Transactional
	public void 팀등록(Team team) {
		Field fieldEntity = fieldRepository.findById(team.getFieldId()).get();
		team.setField(fieldEntity);
		teamRepository.save(team);
	}
	
	@Transactional(readOnly = true)
	public List<Team> 팀리스트(){
		return teamRepository.findAll();
	}

}
