package com.cos.baseball.domain.team;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.baseball.domain.field.Field;

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
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String teamName;
	
	//한 팀은 한 경기장에 등록 가능
	//경기장 삭제 = 팀도 삭제, 팀 삭제 != 경기장 삭제
	//remove는 연관돼서 같이 삭제, detach는 삭제 되던 아무 영향 없음
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "fieldId")
	private Field field;
	
	@Transient // DB에 칼럼 생성x
	private int fieldId;
	

	
	
	
	@CreationTimestamp
	private Timestamp createDate;
}