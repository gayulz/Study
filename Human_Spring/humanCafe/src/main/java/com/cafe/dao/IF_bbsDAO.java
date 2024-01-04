package com.cafe.dao;

import java.util.List;

import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;

public interface IF_bbsDAO {
	//작업을 정의
	public void insert(BBSVO bbsvo);   //추상클래스
	public List<BBSVO> selectAll(PageVO pagevo);
	//반성. 이메서드는 누가 호출하는것인가? 서비스가 호출
	public void delno(String dno);
	// dao를 호출하는 곳은 서비스단이다.. 넘겨줄게 있나? 리턴해 줘야 하나?
	public BBSVO selectOne(String mno);
	public void update(BBSVO bvo);
	public void updateCnt(String vno);
	public int getTotalcnt();
	public int savefilenames(String fname);
	public List<String> getFileNames(String vno);
}
