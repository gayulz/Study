package com.human.task.dao;

import com.human.task.dto.ContactDTO;
import com.human.task.dto.PageVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ContactDAOImpl implements IF_contactDAO{
    //factory mapping정보
    private static String mapperQuery="com.human.task.dao.IF_contactDAO";
    @Inject
    private SqlSession sqlSession;

    // 게시글 총 개수 정보 받아오기
    public int totalPostCnt(){
        return sqlSession.selectOne(mapperQuery+".selectCont");
    }

    // 모든 게시글 조회
    public List<ContactDTO> selectAll(PageVO pageVO){

        return sqlSession.selectList(mapperQuery+".selectAll", pageVO);
    }
    //게시글 추가
    public void insertLine(ContactDTO contactDTO){
        sqlSession.insert(mapperQuery+".insertOne",contactDTO);
    }

    // 게시글 수정
    public void editPost(ContactDTO contactDTO){
       sqlSession.update(mapperQuery + ".update", contactDTO);
    }

    // 게시글 찾아오기
    public ContactDTO selectOne(int contactNum){
        return sqlSession.selectOne(mapperQuery+".selectOne", contactNum);
    }

    // 삭제
    public void deletePost(int contactNum){
        sqlSession.delete(mapperQuery+".delete", contactNum);
    }

}
