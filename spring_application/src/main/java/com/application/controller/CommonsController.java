package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/accessDenied")
	public void addcessDenied() {}
	
	@GetMapping("/loginTimeOut")
	public String loginTimeOut(Model model) throws Exception {
		String url = "/commons/sessionOut";
		model.addAttribute("message", "세션이 만료되었습니다.\\n다시 로그인 하세요!");
		return url;
	}
	
	@GetMapping("/loginExpired")
	public String loginExpired(Model model) throws Exception {
		String url = "/commons/sessionOut";
		model.addAttribute("message", "다른 장치에서 중복 로그인이 확인되었습니다."
						 + "\\n다시 로그인 하세요!");
		return url;
	}
	
	
//	@PostMapping("/login")
//	public String loginPost(String id, String pwd,HttpSession session)throws Exception{
//		String url="redirect:/index";
//		
//		MemberVO member=null;
//		member = memberService.getMember(id);			
//				
//		if(member!=null && pwd.equals(member.getPwd())) { //로그인 성공.
//				session.setAttribute("loginUser",member);
//		}else {  //아이디 불일치
//			url="redirect://commons/login";
//		}	
//		
//		return url;
//	}
//	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		String url="redirect:/";
//		
//		session.invalidate(); //세션 갱신
//		
//		return url;
//	}
	
	
}
