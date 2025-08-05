package com.spring.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.command.MailRequest;
import com.spring.message.MimeAttachNotifier;

@Controller
public class MailController {

	@Autowired
	private MimeAttachNotifier notifier;
	
	@GetMapping("/form")
	public void mailGet() throws Exception{}
	
	@PostMapping(value="/sendMail", produces="text/plain;charset=utf-8")
	public String mailPost(MailRequest mailReq,RedirectAttributes rttr)throws Exception{
		String url = "redirect:/success";

		MultipartFile attach=mailReq.getFile();
		String uploadPath = "c:/mail/attach";
		
		//파일유무
		if(attach!=null && !attach.isEmpty()){
			// 파일저장
			if(attach.getSize()<1024*1024*5){
				//파일저장
				File file = new File(uploadPath,attach.getOriginalFilename());
				file.mkdirs();				
				
				attach.transferTo(file);
			}else { //용량초과				
				url="redirect:/fail";
				rttr.addFlashAttribute("message","첨부파일이 용량초과 입니다.");				
				return url;
			}
		}
		
		//메일 메세지 보내기	
		try {
			notifier.sendMail(mailReq, uploadPath);
			rttr.addFlashAttribute("mailRequest",mailReq);			
		}catch(Exception e) {
			e.printStackTrace();
			url="redirect:/fail";
			rttr.addFlashAttribute("message","메일 보내기를 실패했습니다..");
		}finally {
			//DB 저장
			// mailService.regist(mailVO);
		}
		
		
		return url;
		
	}
	
	@GetMapping("/success")
	public void mailSuccess() {}
	
	@GetMapping("/fail")
	public void mailFail() {}
}





