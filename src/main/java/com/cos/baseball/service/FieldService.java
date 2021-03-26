package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.field.FieldRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FieldService {
	
	private final FieldRepository fieldRepository;

	//버튼 누르면 DB에 저장됨. 이제 저장된 구장을 list에 그려주기
	//=>FieldController로 이동 
	@Transactional
	public void 야구장등록(Field field) {
		fieldRepository.save(field);
	}
	
	@Transactional(readOnly = true)
	public List<Field> 야구장리스트(){
		return fieldRepository.findAll();
	}

}
