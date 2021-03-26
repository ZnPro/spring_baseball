package com.cos.baseball.domain.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.FieldService;
import com.cos.baseball.service.TeamService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamController {
	
	private final TeamService teamService;
	private final FieldService fieldService;
	
	@GetMapping("/team/saveForm")
	public String saveForm(Model model) {
		List<Field> fields = fieldService.야구장리스트();
		model.addAttribute("fields", fields);
		return "team/saveForm";
	}
	
	@PostMapping("/team/save")
	public String save(Team team) {
		teamService.팀등록(team);
		return "redirect:/team/list";
		//redirect하는 이유?
	}
	
	@GetMapping("/team/list")
	public String list(Model model) {
		List<Team> teams = teamService.팀리스트();
		model.addAttribute("teams", teams);
		return "team/list";
	}
	
	
}
