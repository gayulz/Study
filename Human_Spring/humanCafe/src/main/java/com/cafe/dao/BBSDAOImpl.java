package com.cafe.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

@Repository
public class BBSDAOImpl implements IF_bbsDAO{
	//Factory mapping 정보
	private static String mapperQuery="com.cafe.dao.IF_bbsDAO";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insert(BBSVO bbsvo) {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery+".insertOne", bbsvo);
	}

	@Override
	public List<BBSVO> selectAll(PageVO pagevo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuery+".selectAll",pagevo);
	}

	@Override
	public void delno(String dno) {
		sqlSession.delete(mapperQuery+".delone",dno );
		
	}

	@Override
	public BBSVO selectOne(String mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery+".selectOne", mno);
	}

	@Override
	public void update(BBSVO bvo) {
		sqlSession.update(mapperQuery+".updateOne", bvo);
		
	}

	@Override
	public void updateCnt(String vno) {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuery+".updatecnt", vno);
		
	}

	@Override
	public int getTotalcnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery+".totalcnt");
	}

	@Override
	public int savefilenames(String fname) {
		// TODO Auto-generated method stub
		return sqlSession.insert(mapperQuery+".saveFile",fname);
	}

	@Override
	public List<String> getFileNames(String vno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuery+".selectFiles", vno);
	}

	
	
	
	
	
	
	
	
	
	
	
}
