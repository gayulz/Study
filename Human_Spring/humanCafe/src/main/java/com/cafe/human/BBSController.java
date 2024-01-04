package com.cafe.human;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe.service.IF_bbsService;
import com.cafe.util.FileDataUtil;
import com.cafe.vo.BBSVO;
import com.cafe.vo.PageVO;


@Controller
public class BBSController {
	
	//IF_bbsDAO bbsdao = new BBSDAOImpl();  // 가능하지만 이것을 스프링이라 할 수없다.
	@Inject
	IF_bbsService bbsservice; // 컨테이너로 부터 객체의 주소를 주입 받는다.
	@Inject
	FileDataUtil filedataUtil;
	@RequestMapping(value = "bbswrpro" , method = RequestMethod.POST)
	public String bbswrpro(Model model, BBSVO bbsvo, MultipartFile[] file) throws Exception{//BBSVO bbsvo String parameter 받기
		                                             // MultipartFile[] file 첨부파일 파라미터 을 받기 위한 설정
//		for(int i=0; i < file.length; i++) {
//			System.out.println(i +"번 파일 이름 : "+file[i].getOriginalFilename());
//			System.out.println(file[i].getName());
//			System.out.println(file[i].getSize());
//		}
		System.out.println(file[0].getOriginalFilename());
		System.out.println(file[1].getOriginalFilename());
		String[] fileNames = filedataUtil.fileUpload(file);  // 첨부파일을 저장하고 새로만든파일명을 리턴
		bbsvo.setFiles(fileNames);		// 새로만든 파일명을 vo객체에 저장합니다. 
		bbsservice.insertline(bbsvo);   //  서비스 단에게 넘김..
		return "redirect:bbsview";
	}
	
	@RequestMapping(value = "bbsmodpro" , method = RequestMethod.POST)
	public String bbmodpro(Model model, @ModelAttribute BBSVO bvo) {
		
		
		bbsservice.update(bvo);
		return "redirect:bbsview";
	}
	
	@RequestMapping(value = "bbsview", method = RequestMethod.GET)
	public String join(Model model, @ModelAttribute PageVO pagevo) {
		
		//PageVO pagevo = new PageVO();
		//pagevo.setPage(Integer.valueOf(page));
		if(pagevo.getPage()==null) {
			pagevo.setPage(1);
		}
		//System.out.println(bbsservice.getTotalcnt());
		pagevo.setTotalCount(bbsservice.getTotalcnt());  //select count(*) from bbs  결과를 받아온다.
		pagevo.prt();
		// page의 값에 따라 현재 페이지 시작 글번호와 끝 글 번호를 출력하시오.
		System.out.println(pagevo.getStartNo()+"/"+pagevo.getEndNo());
		
		// 출력이 된 사람은 .. html view까지 작업을 해 보세요.. 
		// selectAll 메서드를 호출할때 pagevo를 매개변수로 넘겨 주면 됨.
		List<BBSVO> bbslist = bbsservice.selectAll(pagevo);
		model.addAttribute("blist", bbslist); //모든 자료형이 추상화 되있어서
		model.addAttribute("pagevo", pagevo);
		
		
		// 어떤 변수명에 어떤 자료형을 전달할 것인지 생각해야 한다.  리스트를 전달함...
		return "bbslist";  // 논리적인 view이름. 뷰리졸브 pre suf 실제 뷰를 만든다.
	}
	@RequestMapping(value = "bbswr" , method = RequestMethod.GET)
	public String bbswr(Model model, HttpSession session) {
		String viewName= "wrform";
		if(session.getAttribute("userid")==null) {
			viewName="home";
		}
		
		return viewName;   // forwarding 방식
	} 	
	@RequestMapping(value = "bbsmod" , method = RequestMethod.GET)
	public String bbsmod(Model model, @RequestParam("mno") String mno) {
		// 의도가 작성한 글 가져오기.. 서비스단이 필요하다..
		BBSVO bvo = bbsservice.selectOne(mno);
		model.addAttribute("mbvo", bvo);
		return "bbsmodform";   // forwarding 방식
	} 
	
	@RequestMapping(value = "bbsdetail" , method = RequestMethod.GET)
	public String bbsdetail(Model model, @RequestParam("vno") String vno) {
		
		//첨부파일 가져오기
		// 쿼리 " select * from bbs_files where bbs_num=${vno}  리턴타입 List
		List<String> files = bbsservice.getFileNames(vno);	
		model.addAttribute("files", files);
		model.addAttribute("nowvo", bbsservice.detailview(vno));
		return "view";   // forwarding 방식
	} 
	
	@RequestMapping(value = "bbsdel" , method = RequestMethod.GET)
	public String bbsdel(Model model, @RequestParam("dno") String ddno) {
		System.out.println(ddno);
		// 삭제 요청 > 서비스단에합니다.
		bbsservice.deleteNum(ddno);		
		//return "bbslist";  // 글 삭제를 하고 글 리스트 보여주기로 화면전환을 하고 싶다
		              // 52번 라인처럼 포워딩을 하면 ? 글이 안보여 진다. 이유는 모델
		              //이 글 리스트를 넘겨주지 않아서..그래서 이때는 다시 컨트롤러 돌린다
		               // 이것을 리다이렉트라고 한다.
		return "redirect:bbsview";
	}
	
	
}
