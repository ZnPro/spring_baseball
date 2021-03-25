package com.cos.baseball.domain.web.dto;

import com.cos.baseball.domain.player.Player;

import lombok.Data;

@Data
public class PlayerRegReqDto {
	
	//player 등록할 때 입력해야 하는 정보: player 이름.
	
	private String playerName;

	public Player toEntity() {
		return Player.builder()
				.playerName(playerName)
				.build();
	}

}
