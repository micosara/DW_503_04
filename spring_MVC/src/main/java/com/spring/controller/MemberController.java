package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.command.RegistCommand;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/registForm")
	public void registForm() {}
	
	@PostMapping("/regist")
	public String registPost(@ModelAttribute("command") RegistCommand regData) {
		String url = "/member/regist_success";
		
		
		return url;
	}
}







