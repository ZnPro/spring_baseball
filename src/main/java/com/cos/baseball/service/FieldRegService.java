package com.cos.baseball.service;

import org.springframework.stereotype.Service;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.field.FieldRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FieldRegService {
	
	private final FieldRepository fieldRepository;

	
	public Field 야구장장등록하기(Field field) {
		return fieldRepository.save(field);
	}

}
