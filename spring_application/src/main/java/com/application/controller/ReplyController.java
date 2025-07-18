package com.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.command.PageMaker;
import com.application.dto.ReplyVO;
import com.application.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@GetMapping("/list")
	public ResponseEntity<Map<String,Object>> list(int bno, PageMaker pageMaker)
																throws Exception{
		ResponseEntity<Map<String,Object>> result=null;
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		List<ReplyVO> replyList = replyService.list(bno, pageMaker);
		
		dataMap.put("replyList", replyList);
		dataMap.put("pageMaker", pageMaker);
		
		result = new ResponseEntity<Map<String,Object>>(dataMap,HttpStatus.OK);
		
		return result;
	}
}
