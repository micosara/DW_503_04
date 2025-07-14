package com.application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.application.command.MemberModifyCommand;
import com.application.command.MemberRegistCommand;
import com.application.command.PageMaker;
import com.application.dto.MemberVO;
import com.application.exception.BadRequestPictureException;
import com.application.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/list")
	public void list(@ModelAttribute PageMaker pageMaker, Model model) throws Exception {
		List<MemberVO> memberList = service.list(pageMaker);
		model.addAttribute("memberList", memberList);
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

	
	@Resource(name = "picturePath")
	private String picturePath;
	
	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public ModelAndView regist(MemberRegistCommand regCommand, ModelAndView mnv) {
		String url = "/member/regist_success";
		
		MultipartFile multi = regCommand.getPicture();
		try {
			
			String fileName = savePicture(null, multi);
			
			// DB 저장
			MemberVO member = regCommand.toMemberVO();
			member.setPicture(fileName);

			service.regist(member);
		}catch(BadRequestPictureException e) {
			url = "/member/no_picture";
			
		} catch (Exception e) {
			url = "/error/500";
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		return mnv;
	}
	
	
	public String savePicture(String oldPicture, MultipartFile multi) 
									throws BadRequestPictureException, 
											IllegalStateException, IOException {
		
		if (multi == null || multi.isEmpty() || multi.getSize() > 1024 * 1024 * 1) {
			throw new BadRequestPictureException();
		}
			
		// 저장 파일명
		String fileName = null;

		// 파일저장폴더설정
		String uploadPath = this.picturePath;

		// 파일유무확인, 저장 파일명 결정
		String uuid = UUID.randomUUID().toString().replace("-", "");
		fileName = uuid + "$$" + multi.getOriginalFilename();
		File storeFile = new File(uploadPath, fileName);

		// 파일경로 생성
		storeFile.mkdirs();

		// local HDD 에 저장.
		multi.transferTo(storeFile);
		
		//기존 이미지 삭제
		if (oldPicture != null && !oldPicture.isEmpty()) {
			File oldFile = new File(uploadPath, oldPicture);
			if (oldFile.exists()) {
				oldFile.delete();
			}
		}
		
		return fileName;
	}
	
	
	@GetMapping("/detail")
	public ModelAndView detail(String id, ModelAndView mnv) throws Exception {
		String url = "/member/detail";

		MemberVO member = service.getMember(id);

		mnv.addObject("member", member);
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/getPicture")
	@ResponseBody
	public ResponseEntity<byte[]> getPicture(String id) {
		ResponseEntity entity = null;
			
		MemberVO member = null;
		
		try {
			member = service.getMember(id);
		} catch (SQLException e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (member == null)
			return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		
		String picture = member.getPicture();
		String imgPath = this.picturePath;
		
		InputStream in = null;
		
		try {
			in = new FileInputStream(new File(imgPath, picture));
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), HttpStatus.OK);
			
			return entity;
		}catch(IOException e) {
			System.out.println("Not Founded ::: "+member.getId()+":"+member.getPicture());
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	@GetMapping("/authority/modifyForm")
	public void modifyAuthorityForm(String id,Model model)throws Exception {
		MemberVO member = service.getMember(id);
		model.addAttribute("member",member);		
	}
	
	@PostMapping("/authority/modify")
	public String modify(String id, String[] authorities)throws SQLException{
		String url="/member/authority/success";
		service.modifyAuthority(id, Arrays.asList(authorities));		
		return url;
	}
	
	@GetMapping("/modify")
	public ModelAndView modifyForm(String id, ModelAndView mnv) throws Exception {
		String url = "/member/modify";
		
		MemberVO member = service.getMember(id);
		
		mnv.addObject("member", member);
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping(value = "/modify", produces = "text/plain;charset=utf-8")
	public ModelAndView modify(MemberModifyCommand modifyCommand, ModelAndView mnv) 
																	throws Exception {
		String url = "/member/modify_success";
		
		MemberVO member = modifyCommand.toMemberVO();
		
		MultipartFile multi = modifyCommand.getPicture();
		String oldPicture = service.getMember(member.getId()).getPicture();
		try {
			String fileName = savePicture(oldPicture, multi);
			
			member.setPicture(fileName);
		}catch(BadRequestPictureException e) {
			
			member.setPicture(oldPicture);
			
		}
		
		// DB 수정
		service.modify(member);
		
		mnv.addObject("id",member.getId());
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping(value = "/remove")
	public ModelAndView remove(String id,ModelAndView mnv) throws Exception {
		String url = "/member/remove_success";

		// 이미지 파일을 삭제
		MemberVO member = service.getMember(id);
		String savePath = this.picturePath;
		File imageFile = new File(savePath, member.getPicture());
		if (imageFile.exists()) {
			imageFile.delete();
		}
		// db삭제
		service.remove(id);

		mnv.setViewName(url);
		return mnv;
	}

}










