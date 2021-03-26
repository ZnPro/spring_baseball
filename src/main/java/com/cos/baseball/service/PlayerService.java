package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;
import com.cos.baseball.domain.web.dto.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository palyerRepository;
	private final TeamRepository teamRepository;
	private final EntityManager entityManager;
	

	@Transactional
	public void 선수등록(Player player) {
		Team teamEntity = teamRepository.findById(player.getTeamId()).get();
		player.setTeam(teamEntity);
		palyerRepository.save(player);
	}
	
	@Transactional(readOnly = true)
	public List<Player> 선수리스트(){
		return palyerRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<PlayerPositionRespDto> 포지션별선수리스트(){
		//stringbuffer: 동시접근불가기 때문에 사용하기
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("position, ");
		sb.append("MAX(if(teamId = 1, playerName, \"\")) LG, ");
		sb.append("MAX(if(teamId = 2, playerName, \"\")) LOTTE, ");
		sb.append("MAX(if(teamId = 3, playerName, \"\")) SAMSUNG ");
		sb.append("from player ");
		sb.append("GROUP BY position ");
		Query q = entityManager.createNativeQuery(sb.toString());
		JpaResultMapper result = new JpaResultMapper();
		List<PlayerPositionRespDto> playerPositionRespDto = result.list(q, PlayerPositionRespDto.class);
		return playerPositionRespDto;
	}

}
