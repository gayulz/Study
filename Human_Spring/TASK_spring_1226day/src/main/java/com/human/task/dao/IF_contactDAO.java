package com.human.task.dao;

import com.human.task.dto.ContactDTO;
import com.human.task.dto.PageVO;

import java.util.List;

public interface IF_contactDAO {
    public List<ContactDTO> selectAll(PageVO pageVO);

    public void insertLine(ContactDTO contactDTO);

    // 게시글 수정
    public void editPost(ContactDTO contactDTO);

    // 게시글 찾아오기
    public ContactDTO selectOne(int contactNum);
    // 삭제
    public void deletePost(int number);

}
