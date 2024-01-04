package com.cafe.human;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.service.IF_memberService;
import com.cafe.vo.MemberVO;
@Controller
public class MemberController {	
	@Inject
	IF_memberService memberservice;
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Model model, @ModelAttribute MemberVO mvo) {	
		mvo.prt();
		memberservice.newJoin(mvo);
		return null;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(@ModelAttribute MemberVO mvo, HttpSession session) {
		System.out.println(mvo.getId()+"/"+mvo.getPass());  // 자동으로 변수의 내용을 다 출력해 줍니다. 
		// 디비조회    select * from member where id=? and pass=? //해킹이 대상 -sql injection공격에 취약
		// select * from member where id=?   <선택 :디비에서 vo만 가져오고 컨트롤러가 패스워드 일치 판단>
		MemberVO returnmvo  = memberservice.selectOne(mvo);
		if(returnmvo != null) {
			if(returnmvo.getPass().equals(mvo.getPass())) {
				//세션설정
				if(session.getAttribute("userid") != null) {
					session.removeAttribute("userid");  // 초기화 시킨다. 
				}
				session.setAttribute("userid", mvo.getId()); //세션처리으로 처리하면 뷰에 전달하지 않아도 된다.
				// 세션영역은 어플리케이션 전체입니다.
				session.setAttribute("grade", 2);
			}else {
				System.out.println("비밀번호 틀림");
			}
		}else {
			System.out.println("아이디 없음");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();   //세션 날리기
		return "redirect:/";
	}
}
