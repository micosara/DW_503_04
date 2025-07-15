package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.command.NoticeModifyCommand;
import com.application.command.NoticeRegistCommand;
import com.application.command.PageMaker;
import com.application.dto.NoticeVO;
import com.application.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/main")
	public void main() {}

	@GetMapping("/list")
	public void list(@ModelAttribute PageMaker pageMaker, Model model) throws Exception {
		List<NoticeVO> noticeList = noticeService.list(pageMaker);		
		model.addAttribute("noticeList",noticeList);
	}	
	
	@GetMapping("/regist")
	public void regist() {}
	
	@PostMapping("/regist")
	public String registPost(NoticeRegistCommand regCommand)throws Exception{
		String url = "/notice/regist_success";
	
		NoticeVO notice = regCommand.toNoticeVO();
		
		noticeService.regist(notice);
		
		return url;
	}
	
	@GetMapping("/detail")
	public void detail(int nno, Model model)throws Exception{
		
		NoticeVO notice = noticeService.detail(nno);

		model.addAttribute("notice",notice);
	}
	
	@GetMapping("/modify")
	public void modifyGet(int nno, Model model)throws Exception{
		NoticeVO notice = noticeService.getNotice(nno);
		model.addAttribute("notice",notice);
	}
	
	@PostMapping("/modify")
	public String modifyPost(NoticeModifyCommand modifyCommand)throws Exception{
		String url = "/notice/modify_success";
		
		NoticeVO notice = modifyCommand.toNoticeVO();
		
		noticeService.modify(notice);
		
		return url;
	}
	
	@GetMapping("/remove")
	public String remove(int nno)throws Exception{
		String url="/notice/remove_success";
		
		noticeService.remove(nno);
		
		return url;
	}
}
