package com.EMBAD.service;

import com.EMBAD.vo.StaffVO;

import java.util.List;


public interface IF_staffService {
    // 직원 추가
    public boolean insertHospisStaff(StaffVO vo);
    public boolean insertPrmStaff(StaffVO vo);

    // 로그인로직
    public StaffVO isEmailData(StaffVO vo);

    // 중복된 이메일이 여러개일 경우 비밀번호 일치된 계정이 있는지 확인후 리턴
    public StaffVO chkPass(List<StaffVO> list, StaffVO vo);


    // 정보 업데이트 로직
    public boolean updateStaffInfo(StaffVO vo);
}
