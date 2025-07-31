package com.application.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.command.BoardModifyCommand;
import com.application.command.BoardRegistCommand;
import com.application.command.PageMaker;
import com.application.dto.BoardVO;
import com.application.dto.MemberVO;
import com.application.service.BoardService;
import com.josephoconnell.html.HTMLInputFilter;

@Controller
@RequestMapping("/board")
public class BoardController {

	private BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/main")
	public void main() {}
	
	@GetMapping("/list")
	public void list(@ModelAttribute PageMaker pageMaker, Model model)throws Exception{
		List<BoardVO> boardList = boardService.list(pageMaker);
		
		model.addAttribute("boardList",boardList);		
	}
	
	@GetMapping("/detail")
	public void detail(int bno,HttpSession session, Model model)throws Exception{
		
		ServletContext ctx = session.getServletContext();
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		String key = "board:"+member.getId()+bno;
		
		if(ctx.getAttribute(key)!=null) {
			model.addAttribute("board",boardService.getBoard(bno));
		}else {
			ctx.setAttribute(key, key);
			model.addAttribute("board",boardService.detail(bno));
		}
	}
	
	@GetMapping("/regist")
	public void registForm() {}
	
	@PostMapping("/regist")
	public String registPost(BoardRegistCommand regCommand)throws Exception{
		String url = "/board/regist_success";
		
		BoardVO board = regCommand.toBoard();
		board.setTitle(HTMLInputFilter.htmlSpecialChars(board.getTitle()));
		
		boardService.regist(board);
		
		return url;
	}
	
	@GetMapping("/modify")
	public void modifyForm(int bno, Model model)throws Exception{
		BoardVO board = boardService.getBoard(bno);
		
		model.addAttribute("board",board);
	}
	
	@PostMapping("/modify")
	public String modifyPost(BoardModifyCommand modifyCommand)throws Exception{
		
		String url = "/board/modify_success";
		
		BoardVO board = modifyCommand.toBoardVO();
		board.setTitle(HTMLInputFilter.htmlSpecialChars(board.getTitle()));
		
		boardService.modify(board);
		
		return url;		
	}
	
	
	@GetMapping("/remove")
	public String remove(int bno)throws Exception{
		String url="/board/remove_success";		
		
		boardService.remove(bno);
		
		return url;
	}
}