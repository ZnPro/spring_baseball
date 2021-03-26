package com.cos.baseball.domain.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.service.FieldService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@Lazy //스프링 빈 순환 종속성 문제 해결은 되는데...
public class FieldController {
	
	private final FieldService fieldService;
	
	@GetMapping({"/", "/field/saveForm"})
	public String saveForm() {
		return "field/saveForm";
	}
	
	//사직구장 입력하고 버튼 누르면 이동
	//FieldService로 이동
	@PostMapping("/field/save")
	public String save(Field field) {
		fieldService.야구장등록(field);
		return "redirect:/field/list";
		//redirect하는 이유?
	}
	
	//그려주는걸 Model을 이용해서 그리기
	@GetMapping("/field/list")
	public String list(Model model) {
		List<Field> fields = fieldService.야구장리스트();
		model.addAttribute("fields", fields);
		return "/field/list";
	}
	//야구장리스트를 FieldService에 만들러 간다.
	
	@DeleteMapping("/field/{id}")
	public @ResponseBody String delete(@PathVariable Integer id) {
		fieldService.삭제하기(id);
		return "ok";
	}

}
