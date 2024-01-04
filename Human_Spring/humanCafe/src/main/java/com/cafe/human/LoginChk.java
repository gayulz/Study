package com.cafe.human;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.service.IF_bbsService;
import com.cafe.service.IF_memberService;
import com.cafe.vo.MemberVO;


@RestController    // controller + responsebody 
public class LoginChk {
	
	@Inject
	IF_memberService memberservice;
	
	@RequestMapping(value = "idchk" , method = RequestMethod.POST)
	public int bbswr(@RequestBody Map<String, Object> a) {  //map으로 받는다..  js에서 json으로 여러개 보내서
	//public String bbswr(@RequestParam("userid") String userid,@RequestParam("test") String test ) {  // text받기
		//System.out.println((String)a.get("userid")); 
		//System.out.println((String)a.get("test"));
		String uid = (String)a.get("userid");
		MemberVO mvo = new MemberVO();
		mvo.setId(uid);
	
		/*  userid로 가입된 사람이 있는지 확인 후 리턴하시오..*/
		MemberVO rmvo = memberservice.selectOne(mvo);
		// mvo가 null인지 출력하시오.. //*/
		
		if(rmvo == null) {
			return 1;
		}else {
			return 0;
		}		
		 //이제는 view이름이 아니라, 클라이언트에게 보낼 자료가 되는 것이다.
	} 	

}
