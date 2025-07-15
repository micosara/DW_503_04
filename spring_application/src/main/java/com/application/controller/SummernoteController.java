package com.application.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/summernote")
public class SummernoteController {

	@Resource(name="summernotePath")
	private String summernotePath;
	
	@PostMapping(value="/uploadImg")
	public ResponseEntity<String> uploadImg(MultipartFile file,HttpServletRequest request)	
															throws IOException {
		ResponseEntity<String> result = null;
		
		//System.out.println(file.getOriginalFilename());
	
		String fileName = UUID.randomUUID().toString()+".jpg"; 
		File saveFile = new File(summernotePath, fileName);
		
		saveFile.mkdirs();
		
		file.transferTo(saveFile);
		

		result = new ResponseEntity<String>(request.getContextPath() 
				+ "/summernote/getImg?fileName=" + fileName,HttpStatus.OK);
		
		return result;
	}
}
