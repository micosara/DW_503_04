package com.application.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.dto.MemberVO;
import com.application.service.MemberService;

@Controller
@RequestMapping("/commons")
public class CommonsController {

	
	private MemberService memberService;
	
	@Autowired
	public CommonsController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/login")
	public String loginGet() {		
		String url = "/commons/loginForm";
		return url;
	}
	
	@PostMapping("/login")
	public String loginPost(String id, String pwd,HttpSession session)throws Exception{
		String url="redirect:/index";
		
		MemberVO member=null;
		member = memberService.getMember(id);			
				
		if(member!=null && pwd.equals(member.getPwd())) { //로그인 성공.
				session.setAttribute("loginUser",member);
		}else {  //아이디 불일치
			url="redirect://commons/login";
		}	
		
		return url;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		String url="redirect:/";
		
		session.invalidate(); //세션 갱신
		
		return url;
	}
	
	
}
