package com.EMBAD.controller;

import com.EMBAD.service.PrmServiceImpl;
import com.EMBAD.vo.PrmVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

@Controller
public class InfoController {

    @Inject
    PrmServiceImpl prmService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        String formattedDate = "nodata";
        model.addAttribute("serverTime", formattedDate);
        return "index";
    }

    /**
     * @param : int 병원관계자 1, 구급구조사 2
     */
    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String signUp(Model model, @RequestParam("userType") String type) {
        model.addAttribute("type", type);
        if (type.equals("1")) {
            List<PrmVO> prmList = prmService.prmListAll();
            model.addAttribute("prmList", prmList);
        }
        return "signup";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 무효화
        }
        return "redirect:/"; // 로그인 페이지로 리다이렉션
    }


}
