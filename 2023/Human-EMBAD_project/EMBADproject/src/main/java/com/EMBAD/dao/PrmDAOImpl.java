package com.EMBAD.dao;

import com.EMBAD.vo.PrmVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class PrmDAOImpl implements IF_prmDAO {

    private static String staffInsertQuery="com.EMBAD.dao.staffMapper";

    @Inject
    private SqlSession sqlSession;

    // 등록된 구급업체 조회 쿼리 , 리턴값 List<PrmVo>
    @Override
    public List<PrmVO> prmSelectAll() {
        List<PrmVO> list = sqlSession.selectList(staffInsertQuery+".getPrmAllData");
        return list;
    }
}
