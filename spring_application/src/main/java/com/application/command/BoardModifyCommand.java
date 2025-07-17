package com.application.command;

import com.application.dto.BoardVO;

public class BoardModifyCommand extends BoardRegistCommand{

	private int bno;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = super.toBoard();
		
		board.setBno(bno);
		
		return board;
	}
}
