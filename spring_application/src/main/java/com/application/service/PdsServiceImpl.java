package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dao.PdsDAO;
import com.application.dto.AttachVO;
import com.application.dto.PdsVO;

public class PdsServiceImpl implements PdsService{
	private PdsDAO pdsDAO;
	
	
	public PdsServiceImpl(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}

	@Override
	public List<PdsVO> searchList(PageMaker pageMaker) throws SQLException {
		List<PdsVO> pdsList = pdsDAO.selectSearchPdsList(pageMaker);
		
		int listTotalCount = pdsDAO.selectSearchPdsListCount(pageMaker);
		pageMaker.setTotalCount(listTotalCount);
		
		return pdsList;
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = pdsDAO.selectPdsSeqNext();
		pds.setPno(pno);
		pdsDAO.insertPds(pds);
	}

	@Override
	public PdsVO detail(int pno) throws SQLException {
		pdsDAO.increaseViewCnt(pno);
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		return pds;
	}


	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		return pds;
	}
	
	@Override
	public void modify(PdsVO pds) throws SQLException {
		pdsDAO.updatePds(pds);
		
	}

	@Override
	public void remove(int pno) throws SQLException {
		pdsDAO.deletePds(pno);		
	}
	
}
