package com.EMBAD.dao;

import com.EMBAD.vo.StaffVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StaffDaoImpl implements IF_staffDAO{

    //factory mapping정보
    private static String basicsQuery="com.EMBAD.dao";
    private static String staffInsertQuery="com.EMBAD.dao.staffMapper";

    @Inject
    private SqlSession sqlSession;



    // 병원 관계자 회원가입 처리 : mapper 매칭 후 처리결과 반환 , 리턴값 boolean
    @Override
    public boolean insertHospitalStaff(StaffVO vo) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dutyname", vo.getDutyName());
        paramMap.put("hpid", vo.getHpid());
        paramMap.put("staffEmail", vo.getStaffEmail());
        paramMap.put("staffName", vo.getStaffName());
        paramMap.put("staffPass", vo.getStaffPass());
        paramMap.put("staffPhone", vo.getStaffPhone());

        int result = sqlSession.insert(staffInsertQuery + ".insertStaffData", paramMap);
        if(result == -1) {
            return true;
        }
        return false;
    }

    /**구급 관계자 회원가입 처리 : mapper 매칭 후 처리결과 반환 , 리턴값 boolean*/
    @Override
    public boolean insertPrmStaff(StaffVO vo) {
        int result = sqlSession.insert(staffInsertQuery+".insertPrmStaff", vo);
        if (result==1)return true;
        return false;
    }

    /**이메일 중복체크 dao , cont(*)구문으로 일치된 이메일이 0개라고 나오면
    일치된 이메일이 없는 것 으로 true를 반환
    일치된 이메일이 0개 초과일 경우 있는것으로 판단하여 false를 반환*/
    @Override
    public int checkEmailDuplication(String email) {
        return sqlSession.selectOne(basicsQuery + ".checkEmail", email);
    }

    /**
     * 전송된 이메일이 일치된 사람이 2명 이상일 때
     */
    @Override
    public List<StaffVO> listEmailData(StaffVO vo) {
        List<StaffVO> list = sqlSession.selectOne(staffInsertQuery+".selectIsEmail", vo);
        return list;
    }

    /**
     * 일치 이메일이 한 개 일 때
     */
    @Override
    public StaffVO oneEmailData(StaffVO vo) {
        return sqlSession.selectOne(staffInsertQuery+".selectIsEmail", vo);
    }

    /**
     * 이메일을 기준으로 정보를 업데이트할때 */
    @Override
    public boolean updateStaffInfo(StaffVO vo) {
        int result = sqlSession.update(staffInsertQuery+".staffUpdate", vo);
        if (result==1)return true;
        return false;
    }

}
