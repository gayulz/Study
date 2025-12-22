package com.EMBAD.service;

import com.EMBAD.dao.StaffDaoImpl;
import com.EMBAD.vo.StaffVO;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;


@Service
public class StaffServiceImpl implements IF_staffService {

    // Bean 주입
    @Inject
    StaffDaoImpl staffDao;


    // 병원 관계자 회원가입 로직
    @Override
    public boolean insertHospisStaff(StaffVO vo) {
        return staffDao.insertHospitalStaff(vo);
    }


    // 구급 관계자 회원가입 로직
    @Override
    public boolean insertPrmStaff(StaffVO vo) {
        boolean result = staffDao.insertPrmStaff(vo);
        return result;
    }


    // 이메일 체크
    private int emailCnt(String email){
        return staffDao.checkEmailDuplication(email);
    }


    // 이메일로 db에서 일치된 이메일을 가져온뒤 비밀번호 매칭
    @Override
    public StaffVO isEmailData(StaffVO vo) {
        int emailCnt = emailCnt(vo.getStaffEmail());
        if(emailCnt==0) return null;
        switch (emailCnt){
            case 1 :
                StaffVO oneVO = staffDao.oneEmailData(vo);
                if (oneVO.getStaffPass().equals(vo.getStaffPass())) return oneVO;
                break;
            default:
                return chkPass(staffDao.listEmailData(vo), vo);
        }
        return null;
    }


    // 중복된 이메일이 여러개일 경우 비밀번호 일치된 계정이 있는지 확인후 리턴
    @Override
    public StaffVO chkPass(List<StaffVO> list, StaffVO vo){
        for(int i = 0;i< list.size();i++) {
            StaffVO temp = list.get(i);
            if (temp.getStaffEmail().equals(vo.getStaffEmail())
                    && temp.getStaffPass().equals(vo.getStaffPass()))
                return temp;
        }
        return null;
    }

    @Override
    public boolean updateStaffInfo(StaffVO vo){
        return staffDao.updateStaffInfo(vo);
    }
}
