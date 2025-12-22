package com.EMBAD.service;

import com.EMBAD.dao.PrmDAOImpl;
import com.EMBAD.vo.*;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PrmServiceImpl implements IF_prmService{
    @Inject
    PrmDAOImpl prmDAO;

    @Inject
    HospitalDataAPI hospitalDataAPI;

    @Inject
    PrmHospitalAPI prmHospitalAPI;


    // 등록된 구급업체를 찾아서 리턴해줌
    @Override
    public List<PrmVO> prmListAll() {
        return prmDAO.prmSelectAll();
    }

    // 사용자에게 입력받는다
    // 전 지역의 병원값을 받는다
    // 사용자가 요구한 값과 매칭시킨다
    // 매칭된 지역을 리턴해준다resultData
    // 지도에 해당 위도와 경도를 뽑아서 지도를 그린다
    // 사용자 리스트에 보여준다
    public List<EgytBassInfoInqireVO> prmMatchHospitalList(HashMap<String, Object> resultData){

        // 경기도로 먼저 값 받아오기
        Document gyDom = returnDOM("경기도");
        // 데이터 파싱
        List<String> gyList = prmHospitalAPI.returnMatchHospital(gyDom, resultData);
        // 서울특별시로 값 받아오기
        Document seoulDom = returnDOM("서울특별시");
        List<String> seoulList = prmHospitalAPI.returnMatchHospital(seoulDom, resultData);
        // 두개의 리스트 조인
        List<String> join = new ArrayList<>();
        join.addAll(gyList);
        join.addAll(seoulList);
        // 경도 위도가 있는 데이터 받아오기
        return prmHospitalAPI.resultHospitalList(join);
    }

    // 도시명 입력받아 돔형태로 리턴
    private Document returnDOM(String city){
        HospitalReturnVO tempVO = new HospitalReturnVO();
        tempVO.setCity(city);
        StringBuilder gyData = hospitalDataAPI.getHospitalData(tempVO);
        return hospitalDataAPI.returnDomData(gyData);
    }
}
