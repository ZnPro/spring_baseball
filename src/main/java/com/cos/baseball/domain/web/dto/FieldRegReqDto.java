package com.cos.baseball.domain.web.dto;


import com.cos.baseball.domain.field.Field;

import lombok.Data;

@Data
public class FieldRegReqDto {
	
	//field 등록할 때 입력해야 하는 정보: field 이름.
	
	private String fieldName;
	private String teamName;

	public Field toEntity() {
		return Field.builder()
				.fieldName(fieldName)
				.teamName(teamName)
				.build();
	}

}
