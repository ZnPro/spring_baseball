package com.cos.baseball.domain.player;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Lazy;

import com.cos.baseball.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//모델 만들기
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String playerName;
	
	private String position;
	
	//여러명이 한 팀에 등록 가능
	@ManyToOne
	//@JoinColumn(name = "fieldId")
	@JoinColumn(name = "teamId")
	private Team team;
	
	@Transient // DB에 칼럼 생성x
	private int teamId;

	
	
	
	@CreationTimestamp
	private Timestamp createDate;
}
