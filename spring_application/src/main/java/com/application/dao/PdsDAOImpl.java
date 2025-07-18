package com.application.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.application.command.PageMaker;
import com.application.dto.PdsVO;

public class PdsDAOImpl implements PdsDAO{

	private SqlSession session;
	public PdsDAOImpl(SqlSession session) {
		this.session = session;
	}
	@Override
	public List<PdsVO> selectSearchPdsList(PageMaker pageMaker) throws SQLException {

		int offset =pageMaker.getStartRow()-1;
		int limmit = pageMaker.getPerPageNum();
		
		RowBounds rows = new RowBounds(offset,limmit);
		
		return session.selectList("Pds-Mapper.selectSearchPdsList",pageMaker,rows);
	}
	
	@Override
	public int selectSearchPdsListCount(PageMaker pageMaker) throws SQLException {
		return session.selectOne("Pds-Mapper.selectSearchPdsListCount",pageMaker);
	}
	@Override
	public PdsVO selectPdsByPno(int pno) throws SQLException {
		return session.selectOne("Pds-Mapper.selectPdsByPno",pno);
	}
	@Override
	public int selectPdsSeqNext() throws SQLException {		
		return  session.selectOne("Pds-Mapper.selectPdsSeqNext");
	}
	@Override
	public void insertPds(PdsVO pds) throws SQLException {
		session.insert("Pds-Mapper.insertPds",pds);
		
	}
	@Override
	public void updatePds(PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.updatePds",pds);
		
	}
	@Override
	public void increaseViewCnt(int pno) throws SQLException {
		session.update("Pds-Mapper.increaseViewCnt",pno);
		
	}
	@Override
	public void deletePds(int pno) throws SQLException {
		session.delete("Pds-Mapper.deletePds",pno);		
	}
	
}
