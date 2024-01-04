package com.human.task.service;

import com.human.task.dao.ContactDAOImpl;
import com.human.task.dto.ContactDTO;
import com.human.task.dto.PageVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ContactServiceImpl implements IF_contactUS {
    @Inject
    private ContactDAOImpl contactDAO;

    // 글 모두 가져오기
    @Override
    public List<ContactDTO> selectAll(PageVO pageVO) {
        return contactDAO.selectAll(pageVO);
    }
    // 글 추가
    public void insertPost(ContactDTO contactDTO) {
        contactDAO.insertLine(contactDTO);
    }
    // 글 삭제
    public void deletePost(int contactNum){
        contactDAO.deletePost(contactNum);
    }
    // 게시글 1건만 가져옴
    public ContactDTO selectPost(int contactNum){
        return contactDAO.selectOne(contactNum);
    }
    // 게시글 수정
    public void editPost(ContactDTO contactDTO){
        contactDAO.editPost(contactDTO);
    }
    // 게시글 total 가져오기
    public int totalPostCont(){
        return contactDAO.totalPostCnt();
    }
}
