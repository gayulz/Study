package com.EMBAD.controller;

import com.EMBAD.config.SessionChk;
import com.EMBAD.service.ChartServiceImpl;
import com.EMBAD.service.HospitalDataAPI;
import com.EMBAD.vo.EmergencyChart;
import com.EMBAD.vo.HospitalReturnVO;
import com.EMBAD.vo.StaffVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

// todo : 병원 관계자들 컨트롤러
@Controller
public class HospitalController {
    // 병원관계자 첫 화면=로그인
    @RequestMapping(value = "/hospital" , method = RequestMethod.GET)
    public String hospitalInfo(){
        return "hospitalSite/hospitalInfo";
    }

    // 주입
    @Inject
    private HospitalDataAPI hospitalDataAPI;

    @Inject
    private SessionChk sessionChk;

    @Inject
    ChartServiceImpl chartService;

    /**
     * 공공데이터포털 API service 명세 1번째 사용
     * @param : {@link HospitalReturnVO} city 필드만 입력됨
     * @return : {@link HospitalReturnVO} 해당 도시에 있는 병원목록을 List로 반환
     * */
    @RequestMapping(value = "getHospitalData")
    @ResponseBody
    public List<HospitalReturnVO> getHospitalData(@RequestBody HospitalReturnVO request) {
        StringBuilder xmlData = hospitalDataAPI.getHospitalData(request);
        Document parsingData = hospitalDataAPI.returnDomData(xmlData);
        List<HospitalReturnVO> hospitalReturnVO = hospitalDataAPI.returnSignupHospitalData(parsingData);
        return hospitalReturnVO;
    }


// 기관 ID 기준 리턴
    @RequestMapping(value = "/dutyReception")
    public String dutyReceptionList(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        StaffVO staff = (StaffVO)session.getAttribute("staff");
        List<EmergencyChart> list = chartService.selectDutyChart(staff.getHpid());
        model.addAttribute("list", list);
        return "receptionDutyList";
    }

    @RequestMapping(value = "/chartdetail", method = RequestMethod.GET)
    public String chartDetail(@RequestParam int ptntNumber, Model model) {
        model.addAttribute("vo", chartService.oneChartDetail(ptntNumber));
        return "paramedicSite/oneChartDetail";
    }

    @RequestMapping(value = "/deleteChart", method = RequestMethod.POST)
    public String deleteChart(@RequestParam int ptntNumber){
        chartService.deleteChartOne(ptntNumber);
        return "/redirect:/navMenu2Page";
    }

}