package com.cos.baseball.domain.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeamrController {
	
	@GetMapping("/team/saveForm")
	public String saveForm() {
		return "team/saveForm";
	}
	
	@GetMapping("/team/list")
	public String list() {
		return "team/list";
	}


}

