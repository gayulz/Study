package com.cafe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cafe.dao.IF_bbsDAO;
import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;
@Service
public class BBSServiceImpl implements IF_bbsService{
	@Inject  //객체 주입.. 가장 중요한 코드가 .. 이것..
	IF_bbsDAO bbsdao;
	
	@Override
	public void insertline(BBSVO bvo) {
		bbsdao.insert(bvo);		// bbs table에 저장하는 dao를 호출
		String[] filenames = bvo.getFiles();
		if( filenames.length > 0) {  // 첨부파일이 있다..
			for(int i=0; i < filenames.length; i++) {
				if(filenames[i]!=null) {
					bbsdao.savefilenames(filenames[i]);
				}
			}
			//첨부파일을 저장... 
			//query >>  insert into bbs_files values ((select max(bbs_num) from bbs),filenames[i]);
		}				
	}
	@Override
	public List<BBSVO> selectAll(PageVO pagevo) {
		// TODO Auto-generated method stub
		return bbsdao.selectAll(pagevo);
	}
	@Override
	public void deleteNum(String delno) {
		// TODO Auto-generated method stub
		bbsdao.delno(delno);
	}
	@Override
	public BBSVO selectOne(String mno) {
		// TODO Auto-generated method stub
		BBSVO a = bbsdao.selectOne(mno);
		return a;
	}
	@Override
	public void update(BBSVO bvo) {
		// TODO Auto-generated method stub
		bbsdao.update(bvo);
	}
	@Override
	public BBSVO detailview(String vno) {
		// TODO Auto-generated method stub
		bbsdao.updateCnt(vno);
		return bbsdao.selectOne(vno);
	}
	@Override
	public int getTotalcnt() {
		// TODO Auto-generated method stub
		return bbsdao.getTotalcnt();
	}
	@Override
	public List<String> getFileNames(String vno) {
		// TODO Auto-generated method stub
		return bbsdao.getFileNames(vno);
	}
}
