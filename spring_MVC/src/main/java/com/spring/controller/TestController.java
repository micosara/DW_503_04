package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/background")
public class TestController {
	
	@GetMapping("")
	public void background(@ModelAttribute("color") String color) {}
	
	
	@GetMapping("/{color}")
	public String backgroundPath(@ModelAttribute("color")
							   @PathVariable("color")  
	 						   String color) {
		return "background";
	}
	

}









