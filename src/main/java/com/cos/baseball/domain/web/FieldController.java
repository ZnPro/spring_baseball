package com.cos.baseball.domain.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FieldController {
	
	@GetMapping({"/", "/field/saveForm"})
	public String saveForm() {
		return "field/saveForm";
	}
	
	@GetMapping("/field/list")
	public String list() {
		return "field/list";
	}

}
