package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.command.PageMaker;
import com.application.dto.PdsVO;
import com.application.service.PdsService;

@Controller
@RequestMapping("/pds")
public class PdsController {

	@Autowired
	private PdsService pdsService;
	
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute PageMaker pageMaker, ModelAndView mnv) throws Exception {
		String url="/pds/list";
		
		List<PdsVO> pdsList = pdsService.searchList(pageMaker);
		
		mnv.addObject("pdsList",pdsList);
		mnv.setViewName(url);
		return mnv;
	}
	
}







