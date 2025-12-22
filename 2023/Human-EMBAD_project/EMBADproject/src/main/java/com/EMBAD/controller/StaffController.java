package com.EMBAD.controller;

import com.EMBAD.config.SessionChk;
import com.EMBAD.dao.StaffDaoImpl;
import com.EMBAD.service.ChartServiceImpl;
import com.EMBAD.service.StaffServiceImpl;
import com.EMBAD.vo.EmergencyChart;
import com.EMBAD.vo.StaffVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java.lang.Integer.*;

@PropertySource("classpath:application.properties")
// todo : 회원가입 및 로그인에 대한 처리로직 클래스
@Controller
public class StaffController {

    @Value("${KAKAO_MAP_KEY}")
    private String kakaoMapKey;

    @Inject
    private StaffServiceImpl staffService;

    @Inject
    private ChartServiceImpl chartService;

    @Inject
    private SessionChk sessionChk;

    @Inject
    private StaffDaoImpl staffDao;

    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);



    /**
     * 로그인 메서드
     * @param : {@link StaffVO} 입력받은 email, password 확인 후 리디렉션
     */
    @RequestMapping(value = "/prmLogins", method = RequestMethod.POST)
    public String prmLoginAccess(StaffVO staffVO, RedirectAttributes redirectAttributes, Model model, HttpServletRequest request) {
        logger.debug("@controller :: prmLoginAccess :: {}",staffVO.getUserType());
        logger.debug("@controller :: prmLoginAccess :: {}",staffVO.getStaffEmail());
        StaffVO temp = staffService.isEmailData(staffVO);

        if (temp == null) {
            redirectAttributes.addFlashAttribute("loginError", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/"; // 로그인 페이지로 리디렉션
        }
        temp.setUserType(staffVO.getUserType());
        logger.debug("@controller :: prmLoginAccess :: {}",temp.getUserType());
        logger.debug("@controller :: prmLoginAccess1 :: {}",temp.getStaffEmail());

        // 로그인 성공 시 세션에 사용자 정보 저장
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60); // 30분
        session.setAttribute("staff", temp);

        if (temp.getUserType().equals("2")){
        logger.debug("@controller :: prmLoginAccess2 :: {}",temp.getStaffEmail());
            // receptionDutyList 로 이동할때
            return "redirect:/dutyReception";
        }


        logger.debug("@controller :: prmLoginAccess3 :: {}",temp.getStaffEmail());
        model.addAttribute("KAKAO_MAP_KEY", kakaoMapKey);
        return "findEMbad";
    }

    // nav 1번째 메뉴 리디렉션 메서드
    @RequestMapping(value="/navMenu1Page")
    public String navMenu1Page(Model model, EmergencyChart emergencyChart, HttpServletRequest request){
        boolean flag = sessionChk.isLoggedIn(request);
        if (flag){
            HttpSession session = request.getSession(false);
            StaffVO staff = (StaffVO)session.getAttribute("staff");
            int caseTemp = parseInt(staff.getUserType());

            switch(caseTemp){
                case 1 :
                    return "findEMbad";
                default :
                    model.addAttribute("list", chartService.selectDutyChart(staff.getHpid()));
                    return "receptionDutyList";
            }
        }
        return "/";
    }

    // nav 2번째 메뉴 리디렉션 메서드
    @RequestMapping(value = "/navMenu2Page")
    public String navMenu2Page(HttpServletRequest request){
        boolean flag = sessionChk.isLoggedIn(request);
        if (flag){
            HttpSession session = request.getSession(false);
            StaffVO staff = (StaffVO)session.getAttribute("staff");
            int caseTemp = parseInt(staff.getUserType());
            switch(caseTemp){
                //응급구조사 staffNumber로 조회해서 내가 접수한 건만 보이게 끔 한다
                case 1 :
                    return "redirect:/myChartAll";
                default :
                    // 병원 관계자일 경우 병원hpid기준으로 조회 한 뒤 리디렉션
                    return "redirect:/dutyReception";
            }
        }
        return "/";
    }

    // nav 3번째 메뉴 리디렉션 메서드
    @RequestMapping(value = "/navMenu3Page")
    public String navMenu3Page(Model model, HttpServletRequest request){
        boolean flag = sessionChk.isLoggedIn(request);
        if (flag){
            HttpSession session = request.getSession(false);
            StaffVO staff1 = (StaffVO)session.getAttribute("staff");
            StaffVO staff2 = staffDao.oneEmailData(staff1);
            if (staff1.getStaffEmail().equals(staff2.getStaffEmail()) && staff1.getStaffPass().equals(staff2.getStaffPass())){
                model.addAttribute("vo", staff2);
                return "editStaff";
            }
        }
        return "redirect:/navMenu1Page";
    }


    /**
    * 회원가입 메서드
    * staffVO.getuserType : 1 -> 구급 관계자 회원가입
    * staffVO.getuserType : 2 -> 병원 관계자 회원가입
    * @param : 없음
    * @return  : boolean 회원가입 성공 여부 리턴
    */
    @RequestMapping(value="/sendUserData" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> insertStaff(@RequestBody StaffVO staffVO, Model model){
        boolean isResult=false;
        logger.debug("@controller . insertStaff method ;: {}" , staffVO.getDutyName());
        logger.debug("@controller . insertStaff method ;: {}" , staffVO.getHpid());
        if (staffVO.getUserType().equals("1")) isResult=(staffService.insertPrmStaff(staffVO));
        if (staffVO.getUserType().equals("2")) isResult=(staffService.insertHospisStaff(staffVO));
        return ResponseEntity.ok().body("{\"result\":" + isResult + "}");
    }

    /**
     * 회원정보 변경 메서드 */
    @RequestMapping(value="/editStaffInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> editStaffInfo(@RequestBody StaffVO staffVO, HttpServletRequest request){
        logger.debug("@controller . editStaffInfo method :: staffVO :: {}" , staffVO.getStaffEmail());
        boolean flag = sessionChk.isLoggedIn(request);
        boolean isResult=false;
        logger.debug("@controller . editStaffInfo method :: flag :: {}" , flag);
        if (flag){
            HttpSession session = request.getSession(false);
            StaffVO staff1 = (StaffVO)session.getAttribute("staff");
            if (staff1.getStaffEmail().equals(staffVO.getStaffEmail())) {
                logger.debug("@controller . editStaffInfo method :: equals :: true ");
                isResult=staffService.updateStaffInfo(staffVO);
            }
                logger.debug("@controller . editStaffInfo method :: equals :: false ");
        }
                logger.debug("@controller . editStaffInfo method :: isResult :: {} ", isResult);
        return ResponseEntity.ok().body("{\"result\":" + isResult + "}");
    }
}
