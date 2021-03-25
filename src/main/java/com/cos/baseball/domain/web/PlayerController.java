package com.cos.baseball.domain.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {
	
	@GetMapping("/player/saveForm")
	public String saveForm() {
		return "player/saveForm";
	}
	
	@GetMapping("/player/list")
	public String list() {
		return "player/list";
	}
	@GetMapping("/player/positionList")
	public String positionList() {
		return "player/positionList";
	}

}

