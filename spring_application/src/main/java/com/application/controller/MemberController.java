package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.dto.MemberVO;
import com.application.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/list")
	public void list(Model model)throws Exception{
		List<MemberVO> memberList = service.list(); 
		model.addAttribute("memberList",memberList);
	}
	
	@GetMapping("/regist")
	public void registForm() {
	}
	
	@GetMapping("/idCheck")
	@ResponseBody
	public String idCheck(String id) throws Exception {
		String result = "duplicated";
		MemberVO member = service.getMember(id);
		if (member == null)
			result = "";

		return result;
	}
	
}




