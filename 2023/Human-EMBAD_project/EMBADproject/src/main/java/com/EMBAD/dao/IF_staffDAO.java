package com.EMBAD.dao;

import com.EMBAD.vo.StaffVO;

import java.util.List;

public interface IF_staffDAO {
    public boolean insertHospitalStaff(StaffVO vo);
    public boolean insertPrmStaff(StaffVO vo);
    public int checkEmailDuplication(String email);
    public List<StaffVO> listEmailData(StaffVO vo);
    public StaffVO oneEmailData(StaffVO vo);
    public boolean updateStaffInfo(StaffVO vo);
}