package com.cafe.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cafe.vo.MemberVO;
@Repository
public class MemberDAOImpl implements IF_memberDAO{
	
	private static String mapperQuery="com.cafe.dao.IF_memberDAO";
	
	@Inject
	private SqlSession sqlSession;  // mybatis 중 하나의 객체 설정:root-context.xml
	@Override
	public void insert(MemberVO mvo) {
		sqlSession.insert(mapperQuery+".insertOne", mvo);
		
		// com.cafe.dao.IF_memberDAO.insertOne
		
	}
	@Override
	public MemberVO selectOne(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery+".selectOne", mvo);
	}

}
