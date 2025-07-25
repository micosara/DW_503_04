package com.application.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.dto.MemberVO;
import com.application.dto.MenuVO;
import com.application.service.MenuService;

@Controller
public class MainController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("/index")
	public String main(String mcode,Model model, HttpSession session) throws Exception{
		String url="/main";
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null){
			return "redirect:/";
		}
		
		List<MenuVO> menuList = menuService.getMainMenuList();
		
		model.addAttribute("menuList",menuList);
		
		MenuVO menu = null;
		if (mcode != null) {
			menu = menuService.getMenuByMcode(mcode);
		}else {
			menu = menuService.getMenuByMcode("M000000");
		}
		model.addAttribute("menu", menu);
		
		return url;
	}
}



