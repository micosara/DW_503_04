package com.application.service;

import java.sql.SQLException;
import java.util.List;

import com.application.command.PageMaker;
import com.application.dao.AttachDAO;
import com.application.dao.PdsDAO;
import com.application.dto.AttachVO;
import com.application.dto.PdsVO;

public class PdsServiceImpl implements PdsService{
	private PdsDAO pdsDAO;
	private AttachDAO attachDAO;
	
	public PdsServiceImpl(PdsDAO pdsDAO, AttachDAO attachDAO) {
		this.pdsDAO = pdsDAO;
		this.attachDAO = attachDAO;
	}

	@Override
	public List<PdsVO> searchList(PageMaker pageMaker) throws SQLException {
		List<PdsVO> pdsList = pdsDAO.selectSearchPdsList(pageMaker);
		
		if(pdsList !=null) for(PdsVO pds : pdsList) {
			int pno = pds.getPno();
			List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
			pds.setAttachList(attachList);
		}
		
		int listTotalCount = pdsDAO.selectSearchPdsListCount(pageMaker);
		pageMaker.setTotalCount(listTotalCount);
		
		return pdsList;
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = pdsDAO.selectPdsSeqNext();
		pds.setPno(pno);
		pdsDAO.insertPds(pds);
		
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList!=null) for(AttachVO attach : attachList) {
			attach.setPno(pno);
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public PdsVO detail(int pno) throws SQLException {
		pdsDAO.increaseViewCnt(pno);
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		
		List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
		pds.setAttachList(attachList);
		
		return pds;
	}


	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		
		List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
		pds.setAttachList(attachList);
		
		return pds;
	}
	
	@Override
	public void modify(PdsVO pds) throws SQLException {
		pdsDAO.updatePds(pds);
		
		int pno = pds.getPno();
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList!=null) for(AttachVO attach : attachList) {
			attach.setPno(pno);
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public void remove(int pno) throws SQLException {
		attachDAO.deletAllAttach(pno);
		pdsDAO.deletePds(pno);	
	}
	
}




