package com.cos.baseball.domain.field;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
//오류: @OneToOne 랑 @Column 쓸 수 없다.
public class Field {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fieldName;
	
	//여러명이 한 팀에 등록 가능, 한 팀은 한 경기장에 등록 가능
	//=> Team엔티티에 있는 Field 필드와 매핑 되었다. 이 team은 읽기 전용 필드
	//@JoinColumn(name = "teamId")
	@OneToOne(mappedBy = "field", cascade = CascadeType.REMOVE)
	private Team team;
	
	
	@CreationTimestamp
	private Timestamp createDate;

}