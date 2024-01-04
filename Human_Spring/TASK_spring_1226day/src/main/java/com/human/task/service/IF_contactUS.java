package com.human.task.service;

import com.human.task.dto.ContactDTO;
import com.human.task.dto.PageVO;

import java.util.List;

public interface IF_contactUS {

    // 게시글을 가져오는 메서드
    public List<ContactDTO> selectAll(PageVO pageVO);

    // 게시글 추가하는 메서드
    public void insertPost(ContactDTO contactDTO);
}
