package com.EMBAD.controller;

import com.EMBAD.config.SessionChk;
import com.EMBAD.service.ChartServiceImpl;
import com.EMBAD.service.PrmServiceImpl;
import com.EMBAD.vo.EgytBassInfoInqireVO;
import com.EMBAD.vo.EmergencyChart;
import com.EMBAD.vo.PrmVO;
import com.EMBAD.vo.StaffVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@PropertySource("classpath:application.properties")
@Controller
@Configuration
public class ParamedicsController extends SessionChk  {
    // API KEY 정보
    @Value("${KAKAO_MAP_KEY}")
    private String KAKAO_MAP_KEY;
    @Inject
    private PrmServiceImpl prmService;
    @Inject
    private SessionChk sessionChk;
    @Inject
    ChartServiceImpl chartService;

    private static final Logger logger = LoggerFactory.getLogger(ParamedicsController.class);

    @RequestMapping(value = "paramedics", method = RequestMethod.GET)
    public String paramedicsInfo(HttpServletRequest request) {
        if (isLoggedIn(request)) return "paramedicSite/prmMatching";
        return "paramedicSite/prmInfo";
    }


    /** DB저장된 등록된 구급업체 목록 가져오기
    * @return : {@link PrmVO} List형식 구급업체 목록
    */
    @RequestMapping(value = "getPrmsList")
    @ResponseBody
    public List<PrmVO> getHospitalData(Model model) {
        List<PrmVO> prmList = prmService.prmListAll();
        model.addAttribute("post", prmList);
        return prmList;
    }

    /**
    * 공공데이터포털 API 명세서 5번째 service
    * 사용자가 요구하는 필요서비스 정보에 맞는 병원리스트 리턴
    * JSON 형식 , 매번 파라미터 내용 및 갯수 다름 hashMap mapping
    * @return  : {@link EgytBassInfoInqireVO} 사용자 요구사항에 부합한 병원 목록을 List로 반환
    */
    @RequestMapping(value= "/getMatchHospitalData", method = RequestMethod.POST)
    public String getMatchHospitalData(Model model, @ModelAttribute("requestData") @RequestParam HashMap<String, Object> requestData){
        logger.debug("@requestData : {} ", requestData);
        List<EgytBassInfoInqireVO> list = prmService.prmMatchHospitalList(requestData);
        model.addAttribute("list", list);
        model.addAttribute("KAKAO_MAP_KEY", KAKAO_MAP_KEY);
        return "paramedicSite/prmMatching";
    }


    /**
     * 이송 가능 병원 확인 후 해당 병원으로 접수진행 하는 로직 처리
     * @param : hpid (병원 기관ID)
     * */
    @RequestMapping(value = "/chartReception", method = RequestMethod.POST)
    public String goChartReception(Model model, @RequestParam("hpid") String hpid){
        logger.debug("@controller :: hpid :: {}", hpid);
        model.addAttribute("hpid", hpid);
        return "paramedicSite/prmChartReception";
    }



    /**
     * 환자 접수 처리 진행
     */
    @RequestMapping(value = "/HospitalReception" , method = RequestMethod.POST)
    public String hospitalReception(Model model, EmergencyChart emergencyChart, HttpServletRequest request){
        boolean flag = sessionChk.isLoggedIn(request);
        logger.debug("@EmergencyChart ::: {}",emergencyChart.getHpid());
        logger.debug("@EmergencyChart ::: {}",flag);
        if (sessionChk.isLoggedIn(request)) {
            HttpSession session = request.getSession(false);
            StaffVO staff = (StaffVO)session.getAttribute("staff");
            if (staff!=null) {
                String staffNumber = staff.getStaffNumber();
                String email = staff.getStaffEmail();
                emergencyChart.setStaffNumber(staffNumber);
                chartService.inserChart(emergencyChart);

                List<EmergencyChart> list = chartService.selectAll(staffNumber);
                model.addAttribute("list", list);
            }
        }
        return "receptionDutyList";
    }


    @RequestMapping(value="/myChartAll")
    public String myChartListAll(Model model, EmergencyChart emergencyChart, HttpServletRequest request){
        logger.debug("myChartListAll ::: {}",emergencyChart.getHpid());
        if (sessionChk.isLoggedIn(request)) {
            HttpSession session = request.getSession(false);
            StaffVO staff = (StaffVO)session.getAttribute("staff");
            if (staff!=null) {
                String staffNumber = staff.getStaffNumber();
                model.addAttribute("list", chartService.selectAll(staffNumber));
            }
        }
        return "receptionDutyList";
    }
}
