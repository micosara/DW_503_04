package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminLTE")
public class AdminLTEController {

	@GetMapping("/starter")
	public void starter() {}
	
}
